package com.example.music.repository.custom;

import com.example.music.model.ArtistDataDTO;import com.example.music.model.DataDTO;import java.util.List;

public interface DataRepository {
  DataDTO getData();

  List<ArtistDataDTO> gatArtistDTO();
}
