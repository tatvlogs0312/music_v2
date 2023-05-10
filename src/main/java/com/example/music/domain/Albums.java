package com.example.music.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Albums {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albums")
  @SequenceGenerator(name = "albums", sequenceName = "albums_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "albums_name")
  private String albumsName;

  @Column(name = "url_image_albums")
  private String urlImageAlbums;

  @Column(name = "create_at")
  private LocalDateTime createAt;
}
