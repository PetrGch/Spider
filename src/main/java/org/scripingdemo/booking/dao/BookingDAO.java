package org.scripingdemo.booking.dao;

import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingPrice;
import org.scripingdemo.booking.model.BookingRaiting;

import java.util.List;

/**
 * Created by petr on 23.02.18.
 */
public interface BookingDAO {

  public void saveBookingHotel(BookingHotel bookingHotel);
  public void saveBookingDetail(BookingRaiting bookingRaiting);
  public void saveBookingPrice(BookingPrice bookingPrice);
  public BookingHotel searchHotelByCoordinateAndName(String hotelName, String coordinate);

}
