package com.example.music.service;

import com.example.music.model.AlbumsDataDTO;import com.example.music.model.ArtistDataDTO;
import com.example.music.model.DataDTO;
import java.util.List;

public interface DataService {
  DataDTO getDataNumber();

  List<ArtistDataDTO> getArtistData();

  List<AlbumsDataDTO> getAlbumsData();
}
