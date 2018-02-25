package org.scripingdemo.booking.model;

import javax.persistence.*;

/**
 * Created by petr on 25.02.18.
 */
@Entity
@Table(name = "booking_benefit")
public class BookingBenefit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

}
