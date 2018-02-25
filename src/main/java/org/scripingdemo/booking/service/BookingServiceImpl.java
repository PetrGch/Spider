package org.scripingdemo.booking.service;

import org.scripingdemo.booking.dao.BookingDAO;
import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingRaiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by petr on 23.02.18.
 */

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  @Qualifier("bookingDAO")
  BookingDAO bookingDAO;

  @Override
  @Transactional
  public void saveBookingHotel(BookingHotel bookingHotel) {
    bookingDAO.saveBookingHotel(bookingHotel);
  }

  @Override
  @Transactional
  public void saveBookingDetail(BookingRaiting bookingRaiting) {
    bookingDAO.saveBookingDetail(bookingRaiting);
  }

  @Override
  @Transactional
  public BookingHotel searchHotelByCoordinateAndName(String hotelName, String coordinate) {
    return bookingDAO.searchHotelByCoordinateAndName(hotelName, coordinate);
  }
}
