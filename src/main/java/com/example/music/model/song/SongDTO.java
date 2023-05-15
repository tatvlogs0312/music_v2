package com.example.music.model.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongDTO {
  private Long id;
  private String name;
  private String urlImage;
  private String urlMp3;
  private Integer year;
  private Integer length;
  private String artists;
}
