package org.scripingdemo.booking.model;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class BookingMainModel {

  private int id;
  private String uniqueItemId;
  private String name;
  private String date;
  private String type;
  private double discontPrice;
  private double realPrice;
  private String coordinates;

  public BookingMainModel() {
    this.uniqueItemId = UUID.randomUUID().toString();
    this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public BookingMainModel(String name, String type, double discontPrice, double realPrice, String coordinates) {
    this.uniqueItemId = UUID.randomUUID().toString();
    this.name = name;
    this.date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    this.type = type;
    this.discontPrice = discontPrice;
    this.realPrice = realPrice;
    this.coordinates = coordinates;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUniqueItemId() {
    return uniqueItemId;
  }

  public void setUniqueItemId(String uniqueItemId) {
    this.uniqueItemId = uniqueItemId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
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
        + ", uniqueItemId: " + uniqueItemId
        + ", name: " + name
        + ", type: " + type
        + ", date: " + date
        + ", discontPrice: " + discontPrice
        + ", realPrice: " + realPrice
        + ", coordinates: " + coordinates
        + ")";
  }
}
