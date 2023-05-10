package com.example.music.model.artist;

import com.example.music.domain.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistDTO {
  private Long id;
  private String name;
  private String avatar;

  public ArtistDTO(Artist artist) {
    this.name = artist.getName();
  }
}
