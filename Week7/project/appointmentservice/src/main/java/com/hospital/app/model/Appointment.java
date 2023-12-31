package com.hospital.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date slotStart;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date slotEnd;
  private int patient_id;
  private int doctor_id;
  @Transient
  public boolean isValid() {
    return slotStart.before(slotEnd);
  }
}
