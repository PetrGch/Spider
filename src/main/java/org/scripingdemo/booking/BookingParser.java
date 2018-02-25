package org.scripingdemo.booking;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.scripingdemo.booking.model.BookingDetail;
import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingPrice;
import org.scripingdemo.booking.model.BookingRaiting;
import org.scripingdemo.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookingParser {

  // For booking hotel
  private static final String ITEM = "div.sr_item";
  private static final String NAME = "span.sr-hotel__name";
  private static final String TYPE = "span.sr-hotel__type";
  private static final String COORDINATES = "a.district_link";
  private static final String DISTANCE_FROM_CENTER = "span.distfromdest";
  private static final String AMOUNT_OF_PEOPLE = "div.sr_max_occupancy";
  private static final String SPACE = "span.sr-rt-size";

  // For hotel details

  private static final String RATING = "span.sr_main_score_badge span.review-score-badge";
  private static final String SCORE = "div.sr-review-score";
  private static final String COMENTS = "span.review-score-widget__subtext";
  private static final String REPUTATION = "span.review-score-widget__text";

  // For hotel price

  private static final String ACTUAL_PRICE = "span.toggle_price_per_night_or_stay";
  private static final String DISCONT_PRICE = "strong.price > b";
  private static final String FREE_ROOMS = "span.only_x_left";

  @Autowired
  private BookingService bookingService;

  public List<BookingHotel> getMainInfo(Document document) {
    List<BookingHotel> items = new ArrayList<>();

    for (Element e : document.select(ITEM)) {
      BookingHotel bookingHotel = this.getBuildBookingHotel(e);
      BookingDetail bookingDetail = this.getBuildBookingDetail(e);
      BookingPrice bookingPrice = this.getBuildBookingPrice(e);

      System.out.println(bookingHotel);
      BookingHotel foundHotel = bookingService.searchHotelByCoordinateAndName(bookingHotel.getName(), bookingHotel.getCoordinates());
      if (foundHotel != null) {
        foundHotel.setBookingDetail(bookingDetail);
        bookingService.saveBookingHotel(foundHotel);
      } else {
        bookingHotel.setBookingDetail(bookingDetail);
        bookingService.saveBookingHotel(bookingHotel);
      }

      items.add(bookingHotel);
    }

    return items;
  }

  private BookingHotel getBuildBookingHotel(Element e) {
    String name = e.select(NAME).text();
    String type = e.select(TYPE).text();
    String coordinates = e.select(COORDINATES).attr("data-coords");
    double distanceFromCenter = this.distanceConverter(e.select(DISTANCE_FROM_CENTER).text());
    int amountOfPeoples = this.amountOfPeopleConverter(e.select(AMOUNT_OF_PEOPLE));
    int space = this.spaceConverter(e.select(SPACE).text());

    return new BookingHotel(name, type, coordinates, distanceFromCenter, amountOfPeoples, space);
  }

  private double distanceConverter(String distance) {
    Pattern regForMetrsType = Pattern.compile("\\bm\\b");
    Pattern regForMetrs = Pattern.compile("\\d{1,3}");
    Pattern regForKmType = Pattern.compile("\\d{1,2},\\d{1,2}");
    Matcher ifDistanceInMetrs = regForMetrsType.matcher(distance);
    Matcher ifDistanceInKm = regForKmType.matcher(distance);

    if (ifDistanceInMetrs.find()) {
      ifDistanceInMetrs = regForMetrs.matcher(distance);
      if (ifDistanceInMetrs.find()) {
        return Double.parseDouble("0." + ifDistanceInMetrs.group());
      }
    } else if (ifDistanceInKm.find()) {
      return Double.parseDouble(ifDistanceInKm.group().replace(",", "."));
    }

    return 0.0;
  }

  private int amountOfPeopleConverter(Elements e) {
    int emplicitAmountOfPeople = e.select(".bicon").size();
    String multiplierNumber = e.select(".occupancy_multiplier_number").html();

    if (multiplierNumber != null && !multiplierNumber.equals("")) {
      return emplicitAmountOfPeople + Integer.parseInt(multiplierNumber);
    }

    return emplicitAmountOfPeople;
  }

  private int spaceConverter(String space) {
    Pattern p = Pattern.compile("\\b\\d*\\b");
    Matcher m = p.matcher(space);

    if (m.find()) {
      return Integer.parseInt(m.group());
    }

    return 0;
  }

  private BookingDetail getBuildBookingDetail(Element e) {
    double rating = !e.select(RATING).text().isEmpty() ? Double.parseDouble(e.select(RATING).text().replace(",", ".")) : 0.0;
    List<Integer> score = this.parseScore(e.select(SCORE).attr("data-ratings"));
    int locationScore = 0;
    int cleannessScore = 0;
    int priceQuality = 0;
    int comfortScore = 0;
    int staffScore = 0;
    int coments = this.parseComents(e.select(COMENTS).text());
    if (!score.isEmpty()) {
      locationScore = score.get(0);
      cleannessScore = score.get(1);
      priceQuality = score.get(2);
      comfortScore = score.get(3);
      staffScore = score.get(4);
    }
    String reputation = e.select(REPUTATION).text();

    return new BookingDetail(rating, locationScore, cleannessScore, priceQuality, comfortScore, staffScore, coments, reputation);
  }

  private List<Integer> parseScore(String scores) {
    String[] splitedString = scores.split("\\|");
    List<Integer> result = new ArrayList<>();

    if (splitedString.length > 0) {
      for (String s : splitedString) {
        Pattern p = Pattern.compile("\\d{2}");
        Matcher m = p.matcher(s);

        if (m.find()) {
          result.add(Integer.parseInt(m.group()));
        }
      }
    }

    return result;
  }

  private int parseComents(String coments) {
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(coments);

    if (m.find()) {
      return Integer.parseInt(m.group());
    }

    return 0;
  }

  private BookingPrice getBuildBookingPrice(Element e) {
    double actualPrice = this.priceConverter(e.select(ACTUAL_PRICE).text());
    double discontPrice = this.priceConverter(e.select(DISCONT_PRICE).text());
    boolean isAvailable = false;
    int freeRooms = 0;

    if (discontPrice != 0.0) {
      isAvailable = true;
      freeRooms = this.freeRoomsConverter(e.select(FREE_ROOMS).text());
    }

    return new BookingPrice(isAvailable, actualPrice, discontPrice, freeRooms);
  }

  private double priceConverter(String price) {
    Pattern p = Pattern.compile("[0-9]{3,4}(\\.[0-9]{1,2})?");
    Matcher m = p.matcher(price);

    return m.find() ? Double.parseDouble(m.group()) : 0.0;
  }

  private int freeRoomsConverter(String freeRooms) {
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(freeRooms);

    return m.find() ? Integer.parseInt(m.group()) : 0;
  }

}
