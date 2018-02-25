package org.scripingdemo.booking.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingRaiting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petr on 23.02.18.
 */

@Repository
public class BookingDAOImpl implements BookingDAO {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void saveBookingHotel(BookingHotel bookingHotel) {
    Session session = this.sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.saveOrUpdate(bookingHotel);
    tx.commit();
    session.close();
  }

  @Override
  public void saveBookingRaiting(BookingRaiting bookingRaiting) {
    Session session = this.sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.saveOrUpdate(bookingRaiting);
    tx.commit();
    session.close();
  }

  @Override
  public BookingHotel searchHotelByCoordinateAndName(String hotelName, String coordinate) {
    Session session = this.sessionFactory.openSession();
    BookingHotel bookingHotel = null;
    List<BookingHotel> tempResult = new ArrayList<>();

    Query query = null;
    if (coordinate != null && coordinate.trim().length() > 0) {
      query = session.createQuery("FROM BookingHotel b JOIN FETCH b.bookingRaitings WHERE lower(b.coordinates) LIKE :coordinates AND lower(b.name) LIKE :hotelName ");
      query.setParameter("coordinates", "%" + coordinate.toLowerCase() + "%")
          .setParameter("hotelName", "%" + hotelName.toLowerCase() + "%");
    }

    try {
      if (query != null) {
        tempResult = query.list();
        if (!tempResult.isEmpty()) {
          bookingHotel = tempResult.get(0);
        }
      }
    } catch (Exception ex) {
      throw new IllegalArgumentException(ex);
    }

    session.close();

    return bookingHotel;
  }
}
