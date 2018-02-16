package org.scripingdemo.booking.model;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class BookingMainModel {

  private String id;
  private String name;
  private String date;
  private String type;
  private double discontPrice;
  private double realPrice;
  private String coordinates;

  public BookingMainModel() {
    this.id = UUID.randomUUID().toString();
  }

  public BookingMainModel(String name, String type, double discontPrice, double realPrice, String coordinates) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    this.type = type;
    this.discontPrice = discontPrice;
    this.realPrice = realPrice;
    this.coordinates = coordinates;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getDiscontPrice() {
    return discontPrice;
  }

  public void setDiscontPrice(double discontPrice) {
    this.discontPrice = discontPrice;
  }

  public double getRealPrice() {
    return realPrice;
  }

  public void setRealPrice(double realPrice) {
    this.realPrice = realPrice;
  }

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public String toString() {
    return "MainBookingModel: ("
        + "id: " + id
        + ", name: " + name
        + ", type: " + type
        + ", date: " + date
        + ", discontPrice: " + discontPrice
        + ", realPrice: " + realPrice
        + ", coordinates: " + coordinates
        + ")";
  }
}
