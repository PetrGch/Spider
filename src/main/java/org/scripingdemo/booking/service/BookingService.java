package org.scripingdemo.booking.service;

import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingRaiting;

import java.util.List;

/**
 * Created by petr on 23.02.18.
 */
public interface BookingService {

  public void saveBookingHotel(BookingHotel bookingHotel);
  public void saveBookingDetail(BookingRaiting bookingRaiting);
  public BookingHotel searchHotelByCoordinateAndName(String hotelName, String coordinate);

}
