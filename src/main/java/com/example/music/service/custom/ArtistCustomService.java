package com.example.music.service.custom;

import com.example.music.model.artist.ArtistOfSongDTO;
import com.example.music.repository.ArtistRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistCustomService {
  private final ArtistRepository artistRepository;

  public List<ArtistOfSongDTO> getArtistsOfSong(List<Long> ids) {
    List<Object[]> list = artistRepository.findAllByListIdSong(ids);
    if (!list.isEmpty()) {
      return list.stream().map(ArtistOfSongDTO::new).collect(Collectors.toList());
    }

    return new ArrayList<>();
  }
}
