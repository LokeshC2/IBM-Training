package com.example.model;

import lombok.AllArgsConstructor;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class League {
//  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String season;
  private String title;
  private Integer year;
}
