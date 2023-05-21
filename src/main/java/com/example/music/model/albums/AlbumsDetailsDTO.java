package com.example.music.model.albums;

import com.example.music.model.song.SongDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumsDetailsDTO {
  private Long albumsId;
  private String albumsName;
  private String albumsImage;
  List<SongDTO> songOfAlbums;
}
