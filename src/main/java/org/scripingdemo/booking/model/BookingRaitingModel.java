package org.scripingdemo.booking.model;

/**
 * Created by petr on 10.02.18.
 */
public class BookingRaitingModel {

  private int id;
  private double rating;
  private int reviewScore;
  private double locationScore;
  private double cleannessScore;
  private double priceQuality;
  private double comfortScore;
  private double staffScore;
  private int comments;
  private String reputation;

  public BookingRaitingModel() {
//    Empty constructor
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getRaiting() {
    return rating;
  }

  public void setRaiting(double raiting) {
    this.rating = raiting;
  }

  public int getReviewScore() {
    return reviewScore;
  }

  public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
  }

  public double getLocationScore() {
    return locationScore;
  }

  public void setLocationScore(double locationScore) {
    this.locationScore = locationScore;
  }

  public double getCleannessScore() {
    return cleannessScore;
  }

  public void setCleannessScore(double cleannessScore) {
    this.cleannessScore = cleannessScore;
  }

  public double getPriceQuality() {
    return priceQuality;
  }

  public void setPriceQuality(double priceQuality) {
    this.priceQuality = priceQuality;
  }

  public double getComfortScore() {
    return comfortScore;
  }

  public void setComfortScore(double comfortScore) {
    this.comfortScore = comfortScore;
  }

  public double getStaffScore() {
    return staffScore;
  }

  public void setStaffScore(double staffScore) {
    this.staffScore = staffScore;
  }

  public int getComents() {
    return comments;
  }

  public void setComents(int coments) {
    this.comments = coments;
  }

  public String getReputation() {
    return reputation;
  }

  public void setReputation(String reputation) {
    this.reputation = reputation;
  }

  @Override
  public String toString() {
    return "BookingRaitingModel: ("
        + "id: " + id
        + ", rating: " + rating
        + ", reviewScore: " + reviewScore
        + ", locationScore: " + locationScore
        + ", cleannessScore: " + cleannessScore
        + ", priceQuality: " + priceQuality
        + ", comfortScore: " + comfortScore
        + ", staffScore: " + staffScore
        + ", comments: " + comments
        + ", reputation: " + reputation;
  }
}
