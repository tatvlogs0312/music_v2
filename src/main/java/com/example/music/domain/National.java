package com.example.music.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "national")
@Table(name = "national")
public class National {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "national")
  @SequenceGenerator(name = "national", sequenceName = "national_id_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "national_code")
  private String nationalCode;
}
