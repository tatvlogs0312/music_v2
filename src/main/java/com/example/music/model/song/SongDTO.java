package com.example.music.model.song;

import com.example.music.model.artist.ArtistDTO;
import java.util.List;
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
  private Integer year;
  private Integer length;
  private List<ArtistDTO> artists;
}
