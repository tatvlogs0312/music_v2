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
@Entity(name = "like_song")
@Table(name = "like_song")
public class LikeSong {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_song")
  @SequenceGenerator(name = "like_song", sequenceName = "like_song_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "id_song")
  private Long idSong;

  @Column(name = "id_user")
  private Long idUser;

  //True => like
  @Column(name = "status")
  private Boolean status;
}
