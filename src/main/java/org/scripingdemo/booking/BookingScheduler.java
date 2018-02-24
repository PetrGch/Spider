package org.scripingdemo.booking;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingRaiting;
import org.scripingdemo.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class BookingScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentGetter.class);

  @Autowired
  DocumentGetter docGetter;

//  private SessionFactory sessionFactory;
//
//  public void setSessionFactory(SessionFactory sessionFactory) {
//    this.sessionFactory = sessionFactory;
//  }



  @Autowired
  private BookingService bookingService;

  @Scheduled(fixedRate = 10000)
  public void reportCurrentTime() throws UnirestException, InterruptedException {
    UrlModel tempUrl = new UrlModel();
    tempUrl.setCheckinMonthday(2);
    tempUrl.setCheckinMonth(3);
    tempUrl.setCheckinYear(2018);
    tempUrl.setCheckoutMonthday(6);
    tempUrl.setCheckoutMonth(3);
    tempUrl.setCheckoutYear(2018);
    tempUrl.setGroupAdults(2);
    tempUrl.setGroupChildren(0);
    tempUrl.setNoRooms(1);
    tempUrl.setFromSf(1);

    LOGGER.info("Scheduling iteration");

    BookingHotel bookingHotel = bookingService.searchHotelByCoordinateAndName("апартаменти Магнолия", "41.611624,41.638976");

    BookingRaiting bookingRaiting = new BookingRaiting(9.9, 10, 10, 10, 10, 95, 5, "Великолепно Месторасположение");

    if (bookingHotel != null) {

      bookingHotel.add(bookingRaiting);

      bookingService.saveBookingRaiting(bookingRaiting);
      System.out.println(bookingHotel);
    } else {
      System.out.println("Nothing have been found");
    }




////    if (this.sessionFactory != null) {
////      Session session = this.sessionFactory.openSession();
////      Transaction tx = session.beginTransaction();
//      BookingHotel bookingHotel = new BookingHotel("Batumi Wonderland Guest House", "", "41.6454054413864,41.6402908220785", 0.75, 2, 32);
//      BookingRaiting bookingRaiting = new BookingRaiting(9.9, 10, 10, 10, 10, 95, 5, "Великолепно Месторасположение");
//      bookingHotel.add(bookingRaiting);
//
//      System.out.println(bookingHotel);
//      bookingService.saveBookingHotel(bookingHotel);
////      session.saveOrUpdate(bookingHotel);
////      tx.commit();
////      session.close();
////    }

//    docGetter.startScripingProcess(tempUrl);
  }

}
