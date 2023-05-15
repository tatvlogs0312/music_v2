package com.example.music.model.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongOtherDTO {
  private Long id;
  private String name;
  private String urlImage;
  private Integer year;
  private String length;
  private String artists;
}
