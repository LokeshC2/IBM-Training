package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@lombok.Data
public class League {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer year;
  private String season;
  private String title;
}
