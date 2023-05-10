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
@Entity(name = "albums_song")
@Table(name = "albums_song")
public class AlbumsSong {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albums_song")
  @SequenceGenerator(name = "albums_song", sequenceName = "albums_song_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "song_id")
  private Long songId;

  @Column(name = "albums_id")
  private Long albumsId;
}
