package org.scripingdemo.booking;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.scripingdemo.booking.model.BookingMainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookingParser {

  private static final String ITEM = "div.sr_item";
  private static final String NAME = "span.sr-hotel__name";
  private static final String TYPE = "span.sr-hotel__type";
  private static final String DISCOUNT_PRICE = "strong.price b";
  private static final String REAL_PRICE = "span.toggle_price_per_night_or_stay";
  private static final String COORDINATES = "a.district_link";

  @Autowired
  List<BookingMainModel> items;

  @Bean
  private BookingMainModel instance() {
    return new BookingMainModel();
  }

  @Bean
  private BookingMainModel instance(String name, String type, double discontPrice, double reqlPrice, String coordinates) {
    return new BookingMainModel(name, type, discontPrice, reqlPrice, coordinates);
  }

  public List<BookingMainModel> getMainInfo(Document document) {
    items = new ArrayList<>();

    for (Element e : document.select(ITEM)) {
      String name = e.select(NAME).text();
      String type = e.select(TYPE).text();
      double discountPrice = convertStringToDouble(e.select(DISCOUNT_PRICE).text());
      double reslPrice = convertStringToDouble(e.select(REAL_PRICE).text());
      String coordinates = e.select(COORDINATES).attr("data-coords");
      BookingMainModel m = instance(name, type, discountPrice, reslPrice, coordinates);
      System.out.println(m);
      items.add(m);
    }

    return items;
  }

  public double convertStringToDouble(String userString) {
    Pattern p = Pattern.compile("[0-9]{3}(\\.[0-9]{1,2})?");
    Matcher m = p.matcher(userString);

    return m.find() ? Double.parseDouble(m.group()) : 0.0;
  }

}
