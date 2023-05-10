package com.example.music.model.artist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArtistOfSongDTO {
  private Long artistId;
  private Long songId;
  private String name;
  private String avatar;

  public ArtistOfSongDTO(Object[] x){

  }
}
