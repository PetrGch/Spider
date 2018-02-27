package org.scripingdemo.booking;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.scripingdemo.booking.model.BookingDetail;
import org.scripingdemo.booking.model.BookingHotel;
import org.scripingdemo.booking.model.BookingRaiting;
import org.scripingdemo.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@Scope("singleton")
public class BookingScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentGetter.class);

  private boolean isScripingProcesRun = true;

  private UrlModel tempUrl;

  @Autowired
  DocumentGetter docGetter;

  @Scheduled(fixedRate = 30000)
  public void initiateSchedulerForMainInformation() throws UnirestException, InterruptedException {
    tempUrl = new UrlModel();
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

    LOGGER.info("Scheduling iteration for main information");

    if (isScripingProcesRun) {
      docGetter.startScripingProcess(tempUrl, true, false);
    }
  }

  @Scheduled(fixedRate = 10000)
  public void initiateSchedulerForPriceInformation() throws UnirestException, InterruptedException {
    tempUrl = new UrlModel();
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

    LOGGER.info("Scheduling iteration for price information");

    if (isScripingProcesRun) {
      docGetter.startScripingProcess(tempUrl, false, true);
    }
  }


  public boolean isScripingProcesRun() {
    return isScripingProcesRun;
  }

  public void setScripingProcesRun(boolean scripingProcesRun) {
    isScripingProcesRun = scripingProcesRun;
  }

  public UrlModel getTempUrl() {
    return tempUrl;
  }

  public void setTempUrl(UrlModel tempUrl) {
    this.tempUrl = tempUrl;
  }
}
