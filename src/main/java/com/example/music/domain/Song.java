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
@Table(name = "song")
@Entity(name = "song")
public class Song {

  /** id bài hát */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song")
  @SequenceGenerator(name = "song", sequenceName = "song_id_seq", allocationSize = 1)
  private Long id;

  /** tên bài hát */
  @Column(name = "name")
  private String name;

  /** lượt nghe */
  @Column(name = "listens")
  private Integer listens;

  /** độ dài bài hát */
  @Column(name = "length")
  private Integer length;

  /** url hình ảnh */
  @Column(name = "url_image")
  private String urlImage;

  /** url bài hát */
  @Column(name = "url_mp3")
  private String urlMp3;

  /** tìm kiếm */
  @Column(name = "value_search")
  private String valueSearch;

  /** ngày tạo */
  @Column(name = "create_time")
  private LocalDateTime createTime;

  /** id quốc gia */
  @Column(name = "national_id")
  private Long nationalId;

  /** năm sáng tác */
  @Column(name = "year")
  private Integer year;

  /**
   * Lượt thích
   */
  @Column(name = "like_number")
  private Integer likeNumber;

}
