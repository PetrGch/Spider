package org.scripingdemo.booking.model;

/**
 * Created by petr on 10.02.18.
 */
public class BookingSubModel {

  private int id;
  private String distanceFromCenter;
  private String amountOfPeoples;
  private int space;
  private String freeBenefits;
  private String html;

  public BookingSubModel() {
//    Empty constructor
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDistanceFromCenter() {
    return distanceFromCenter;
  }

  public void setDistanceFromCenter(String distanceFromCenter) {
    this.distanceFromCenter = distanceFromCenter;
  }

  public String getAmountOfPeaple() {
    return amountOfPeoples;
  }

  public void setAmountOfPeaple(String amountOfPeaple) {
    this.amountOfPeoples = amountOfPeaple;
  }

  public int getSpace() {
    return space;
  }

  public void setSpace(int space) {
    this.space = space;
  }

  public String getFreeBenefits() {
    return freeBenefits;
  }

  public void setFreeBenefits(String freeBenefits) {
    this.freeBenefits = freeBenefits;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  @Override
  public String toString() {
    return "BookingSubModel: ("
        + "id: " + id
        + ", distanceFromCenter: " + distanceFromCenter
        + ", amountOfPeople: " + amountOfPeoples
        + ", space: " + space
        + ", freeBenefits: " + freeBenefits
        + ", html: " + html;
  }
}
