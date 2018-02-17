package org.scripingdemo.booking;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BookingScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentGetter.class);

  @Autowired
  DocumentGetter docGetter;

  @Scheduled(fixedRate = 100000)
  public void reportCurrentTime() throws UnirestException, InterruptedException {
    UrlModel tempUrl = new UrlModel();
    tempUrl.setCheckinMonthday(19);
    tempUrl.setCheckinMonth(2);
    tempUrl.setCheckinYear(2018);
    tempUrl.setCheckoutMonthday(25);
    tempUrl.setCheckoutMonth(2);
    tempUrl.setCheckoutYear(2018);
    tempUrl.setGroupAdults(2);
    tempUrl.setGroupChildren(0);
    tempUrl.setNoRooms(1);
    tempUrl.setFromSf(1);

    LOGGER.info("Scheduling iteration");

    docGetter.startScripingProcess(tempUrl);
  }

}
