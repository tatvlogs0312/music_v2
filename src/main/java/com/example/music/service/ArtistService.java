package com.example.music.service;

import com.example.music.domain.Artist;
import java.util.List;

public interface ArtistService {
  List<Artist> getArtistLimit10();

  List<Artist> getAllArtistData();
}
