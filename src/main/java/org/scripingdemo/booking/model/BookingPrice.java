package org.scripingdemo.booking.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by petr on 25.02.18.
 */

@Entity
@Table(name = "booking_price")
public class BookingPrice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "is_available")
  private boolean isAvailable;

  @Column(name = "actual_price")
  private double actualPrice;

  @Column(name = "discont_price")
  private double discontPrice;

  @Column(name = "free_rooms")
  private int freeRooms;

  @Column(name = "date")
  private String date;

  public BookingPrice() {}

  public BookingPrice(boolean isAvailable, double actualPrice, double discontPrice, int freeRooms) {
    this.isAvailable = isAvailable;
    this.actualPrice = actualPrice;
    this.discontPrice = discontPrice;
    this.freeRooms = freeRooms;
    this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public double getActualPrice() {
    return actualPrice;
  }

  public void setActualPrice(double actualPrice) {
    this.actualPrice = actualPrice;
  }

  public double getDiscontPrice() {
    return discontPrice;
  }

  public void setDiscontPrice(double discontPrice) {
    this.discontPrice = discontPrice;
  }

  public int getFreeRooms() {
    return freeRooms;
  }

  public void setFreeRooms(int freeRooms) {
    this.freeRooms = freeRooms;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "BookingPrice{" +
        "id=" + id +
        ", isAvailable=" + isAvailable +
        ", actualPrice=" + actualPrice +
        ", discontPrice=" + discontPrice +
        ", freeRooms=" + freeRooms +
        ", date='" + date + '\'' +
        '}';
  }
}
