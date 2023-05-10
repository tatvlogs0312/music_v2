package com.example.music.service.impl;

import com.example.music.domain.Artist;
import com.example.music.repository.ArtistRepository;import com.example.music.service.ArtistService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

  private final ArtistRepository artistRepository;

  @Override
  public List<Artist> getArtistLimit10() {
    return artistRepository.findNewestLimit10();
  }
}
