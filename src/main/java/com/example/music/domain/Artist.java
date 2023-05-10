package com.example.music.domain;

import java.time.LocalDateTime;
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
@Entity(name = "artist")
@Table(name = "artist")
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist")
  @SequenceGenerator(name = "artist", sequenceName = "artist_id_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "url_avatar")
  private String urlAvatar;

  @Column(name = "create_date")
  private LocalDateTime createDate;
}
