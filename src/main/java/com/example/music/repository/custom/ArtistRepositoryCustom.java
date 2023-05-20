package com.example.music.repository.custom;

import com.example.music.model.artist.ArtistOfSongDTO;
import java.util.List;

public interface ArtistRepositoryCustom {
  List<ArtistOfSongDTO> getAllArtistOfSongData(List<Long> idSong);
}
