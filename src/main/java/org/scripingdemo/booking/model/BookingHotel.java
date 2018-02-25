package org.scripingdemo.booking.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by petr on 18.02.18.
 */

@Entity
@Table(name = "booking_hotel")
public class BookingHotel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "unique_item_id")
  private String uniqueItemId;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "coordinates")
  private String coordinates;

  @Column(name = "distance_from_center")
  private double distanceFromCenter;

  @Column(name = "amount_of_people")
  private int amountOfPeoples;

  @Column(name = "space")
  private int space;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "booking_detail_id")
  private BookingDetail bookingDetail;

//  @OneToMany(fetch = FetchType.LAZY,
//      mappedBy = "bookingHotel",
//      cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
//  private List<BookingRaiting> bookingRaitings;

//  public void add(BookingRaiting tempBookingRaitings) {
//    if (bookingRaitings == null) {
//      bookingRaitings = new ArrayList<>();
//    }
//
//    bookingRaitings.add(tempBookingRaitings);
//    tempBookingRaitings.setBookingHotel(this);
//  }

  public BookingHotel() {
    // Empty constructor
  }

  public BookingHotel(String name, String type, String coordinates, double distanceFromCenter, int amountOfPeoples, int space) {
    this.uniqueItemId = UUID.randomUUID().toString();
    this.name = name;
    this.type = type;
    this.coordinates = coordinates;
    this.distanceFromCenter = distanceFromCenter;
    this.amountOfPeoples = amountOfPeoples;
    this.space = space;
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

  public String getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  public double getDistanceFromCenter() {
    return distanceFromCenter;
  }

  public void setDistanceFromCenter(double distanceFromCenter) {
    this.distanceFromCenter = distanceFromCenter;
  }

  public int getAmountOfPeoples() {
    return amountOfPeoples;
  }

  public void setAmountOfPeoples(int amountOfPeoples) {
    this.amountOfPeoples = amountOfPeoples;
  }

  public int getSpace() {
    return space;
  }

  public void setSpace(int space) {
    this.space = space;
  }

//  public List<BookingRaiting> getBookingRaitings() {
//    return bookingRaitings;
//  }
//
//  public void setBookingRaitings(List<BookingRaiting> bookingRaitings) {
//    this.bookingRaitings = bookingRaitings;
//  }


  public BookingDetail getBookingDetail() {
    return bookingDetail;
  }

  public void setBookingDetail(BookingDetail bookingDetail) {
    this.bookingDetail = bookingDetail;
  }

  @Override
  public String toString() {
    return "BookingHotel{" +
        "id=" + id +
        ", uniqueItemId='" + uniqueItemId + '\'' +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", coordinates='" + coordinates + '\'' +
        ", distanceFromCenter='" + distanceFromCenter + '\'' +
        ", amountOfPeoples='" + amountOfPeoples + '\'' +
        ", space=" + space +
//        ", bookingRaitings=" + bookingRaitings +
        '}';
  }
}
