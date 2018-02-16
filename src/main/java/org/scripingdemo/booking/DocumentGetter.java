package org.scripingdemo.booking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@PropertySource(
    value={"classpath*:../resources/foo.properties"},
    ignoreResourceNotFound = true)
public class DocumentGetter {

  @Value("${unirest.proxy.ip}")
  private String ip;
  @Value("${unirest.proxy.port}")
  private int port;
  @Value("${unirest.user-agent.name}")
  private String userAgentName;
  @Value("${unirest.user-agent.value}")
  private String userAgentValue;

  @Autowired
  BookingParser bookingParser;

  private int lastPage = 0;
  private static final String PAGINATION_LI_CLASS = "li.sr_pagination_item";

  public void startScripingProcess(UrlModel bookingUrlModel) throws UnirestException, InterruptedException {
    for (int i = 0; i <= 1; i++) {
      Document document = this.makeRequest(bookingUrlModel, i * 15);
      bookingParser.getMainInfo(document);

      Random r = new Random();
      TimeUnit.SECONDS.sleep(r.nextInt(10));
    }
  }

  private void setLastPageNumber(Document document) {
    if (document != null) {
      lastPage = Integer.parseInt(document.select(PAGINATION_LI_CLASS).last().text());
    }
  }

  private Document makeRequest(UrlModel urlModel, int offset) throws UnirestException {
    Unirest.setDefaultHeader(userAgentName, userAgentValue);
    Unirest.setProxy(new HttpHost(ip, port));

    if (offset != 0) {
      urlModel.setOffset(offset);
    }

    HttpResponse<String> response = Unirest
        .get(UrlModel.BOOKING_URL)
        .queryString(urlModel.getParameters())
        .asString();

    Document document = Jsoup.parseBodyFragment(response.getBody());

    if (lastPage == 0) {
      this.setLastPageNumber(document);
    }

    return document;
  }

}
