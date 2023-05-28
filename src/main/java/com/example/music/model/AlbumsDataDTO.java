package com.example.music.model;

import com.example.music.utils.CommonUtils;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumsDataDTO {
  private Long id;
  private String name;
  private Integer numberSong;

  public AlbumsDataDTO(Object[] temp) {
    AtomicInteger index = new AtomicInteger();
    this.id = CommonUtils.convertValueToLong(temp, index.getAndIncrement());
    this.name = CommonUtils.convertValueToString(temp, index.getAndIncrement());
    this.numberSong = CommonUtils.convertValueToInteger(temp, index.getAndIncrement());
  }
}
