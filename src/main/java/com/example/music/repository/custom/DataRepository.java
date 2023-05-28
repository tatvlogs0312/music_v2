package com.example.music.repository.custom;

import com.example.music.model.AlbumsDataDTO;import com.example.music.model.ArtistDataDTO;import com.example.music.model.DataDTO;import java.util.List;

public interface DataRepository {
  DataDTO getData();

  List<ArtistDataDTO> gatArtistDTO();

  List<AlbumsDataDTO> getAlbumsDTO();
}
