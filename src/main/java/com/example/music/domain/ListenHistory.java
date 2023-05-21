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
@Entity(name = "listen_history")
@Table(name = "listen_history")
public class ListenHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_song")
  @SequenceGenerator(name = "artist_song", sequenceName = "artist_song_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "song_id")
  private Long songId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "listen_time")
  private LocalDateTime listenTime;

  public ListenHistory(Long songId, Long userId){
    this.songId = songId;
    this.userId = userId;
    this.listenTime = LocalDateTime.now();
  }
}
