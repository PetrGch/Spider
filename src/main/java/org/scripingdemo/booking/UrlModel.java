package org.scripingdemo.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UrlModel {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentGetter.class);

  public static final String BOOKING_URL = "https://www.booking.com/searchresults.ru.html?ss=%D0%91%D0%B0%D1%82%D1%83%D0%BC%D0%B8";

  private int checkinMonthday;
  private int checkinMonth;
  private int checkinYear;
  private int checkoutMonthday;
  private int checkoutMonth;
  private int checkoutYear;
  private int groupAdults;
  private int groupChildren;
  private int noRooms;
  private int fromSf = 1;
  private int rows = 15;
  private int offset = 0;
  private Map<String, Object> parameters = null;

  public UrlModel() {
//    Empty constructor
  }

  public int getCheckinMonthday() {
    return checkinMonthday;
  }

  public void setCheckinMonthday(int checkinMonthday) {
    this.checkinMonthday = checkinMonthday;
  }

  public int getCheckinMonth() {
    return checkinMonth;
  }

  public void setCheckinMonth(int checkinMonth) {
    this.checkinMonth = checkinMonth;
  }

  public int getCheckinYear() {
    return checkinYear;
  }

  public void setCheckinYear(int checkinYear) {
    this.checkinYear = checkinYear;
  }

  public int getCheckoutMonthday() {
    return checkoutMonthday;
  }

  public void setCheckoutMonthday(int checkoutMonthday) {
    this.checkoutMonthday = checkoutMonthday;
  }

  public int getCheckoutMonth() {
    return checkoutMonth;
  }

  public void setCheckoutMonth(int checkoutMonth) {
    this.checkoutMonth = checkoutMonth;
  }

  public int getCheckoutYear() {
    return checkoutYear;
  }

  public void setCheckoutYear(int checkoutYear) {
    this.checkoutYear = checkoutYear;
  }

  public int getGroupAdults() {
    return groupAdults;
  }

  public void setGroupAdults(int groupAdults) {
    this.groupAdults = groupAdults;
  }

  public int getGroupChildren() {
    return groupChildren;
  }

  public void setGroupChildren(int groupChildren) {
    this.groupChildren = groupChildren;
  }

  public int getNoRooms() {
    return noRooms;
  }

  public void setNoRooms(int noRooms) {
    this.noRooms = noRooms;
  }

  public int getFromSf() {
    return fromSf;
  }

  public void setFromSf(int fromSf) {
    this.fromSf = fromSf;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setParameters(Map<String, Object> parameters) {
    this.parameters = parameters;
  }

  public Map<String, Object> getParameters() {
    parameters = new HashMap<>();

    if (offset != 0) {
      parameters.put("offset", offset);
    }

    parameters.put("checkin_monthday", checkinMonthday);
    parameters.put("checkin_month", checkinMonth);
    parameters.put("checkin_year", checkinYear);
    parameters.put("checkout_monthday", checkoutMonthday);
    parameters.put("checkout_month", checkoutMonth);
    parameters.put("checkout_year", checkoutYear);
    parameters.put("group_adults", groupAdults);
    parameters.put("group_children", groupChildren);
    parameters.put("no_rooms", noRooms);
    parameters.put("from_sf", fromSf);

    String url = this.toString();
    LOGGER.info("URL: {}", url);

    return parameters;
  }

  @Override
  public String toString() {
    String result = BOOKING_URL
        + "&checkin_monthday=" + checkinMonthday
        + "&checkin_month=" + checkinMonth
        + "&checkin_year=" + checkinYear
        + "&checkout_monthday=" + checkoutMonthday
        + "&checkout_month=" + checkinMonth
        + "&checkout_year=" + checkinYear
        + "&group_adults=" + groupAdults
        + "&group_children=" + groupChildren
        + "&no_rooms=" + noRooms
        + "&from_sf=" + fromSf;

    if (offset != 0) {
      result += ("&offset=" + offset);
    }

    return result;
  }
}
