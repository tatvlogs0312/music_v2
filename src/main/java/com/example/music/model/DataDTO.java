package com.example.music.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataDTO {
  private Long songNumber = 0L;
  private Long artistNumber = 0L;
  private Long albumsNumber = 0L;
  private Long userNumber = 0L;
}
