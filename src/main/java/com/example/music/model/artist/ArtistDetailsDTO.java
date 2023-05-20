package com.example.music.model.artist;

import com.example.music.model.song.SongDTO;import java.util.List;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistDetailsDTO {
  private String artistName;
  private String artistImage;
  List<SongDTO> songOfArtist;
}
