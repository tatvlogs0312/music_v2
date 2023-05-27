package com.example.music.model.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongDataDTO {
  private Long id;
  private String name;
  private Integer year;
  private Integer listen;
  private String artists;
}
