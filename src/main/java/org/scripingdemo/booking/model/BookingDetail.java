package org.scripingdemo.booking.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by petr on 20.02.18.
 */

@Entity
@Table(name = "booking_detail")
public class BookingDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "raiting")
  private double rating;

  @Column(name = "location_score")
  private int locationScore;

  @Column(name = "cleanness_score")
  private int cleannessScore;

  @Column(name = "price_quality")
  private int priceQuality;

  @Column(name = "comfort_score")
  private int comfortScore;

  @Column(name = "staff_score")
  private int staffScore;

  @Column(name = "comments")
  private int comments;

  @Column(name = "reputation")
  private String reputation;

  @Column(name = "date")
  private String date;

  public BookingDetail() {
    // Empty constructor
  }

  public BookingDetail(double rating, int locationScore, int cleannessScore, int priceQuality, int comfortScore, int staffScore, int comments, String reputation) {
    this.rating = rating;
    this.locationScore = locationScore;
    this.cleannessScore = cleannessScore;
    this.priceQuality = priceQuality;
    this.comfortScore = comfortScore;
    this.staffScore = staffScore;
    this.comments = comments;
    this.reputation = reputation;
    this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getLocationScore() {
    return locationScore;
  }

  public void setLocationScore(int locationScore) {
    this.locationScore = locationScore;
  }

  public int getCleannessScore() {
    return cleannessScore;
  }

  public void setCleannessScore(int cleannessScore) {
    this.cleannessScore = cleannessScore;
  }

  public int getPriceQuality() {
    return priceQuality;
  }

  public void setPriceQuality(int priceQuality) {
    this.priceQuality = priceQuality;
  }

  public int getComfortScore() {
    return comfortScore;
  }

  public void setComfortScore(int comfortScore) {
    this.comfortScore = comfortScore;
  }

  public int getStaffScore() {
    return staffScore;
  }

  public void setStaffScore(int staffScore) {
    this.staffScore = staffScore;
  }

  public int getComments() {
    return comments;
  }

  public void setComments(int comments) {
    this.comments = comments;
  }

  public String getReputation() {
    return reputation;
  }

  public void setReputation(String reputation) {
    this.reputation = reputation;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "BookingDetail{" +
        "id=" + id +
        ", rating=" + rating +
        ", locationScore=" + locationScore +
        ", cleannessScore=" + cleannessScore +
        ", priceQuality=" + priceQuality +
        ", comfortScore=" + comfortScore +
        ", staffScore=" + staffScore +
        ", comments=" + comments +
        ", reputation='" + reputation + '\'' +
        ", date='" + date + '\'' +
        '}';
  }
}
