package com.example.music.service.impl;

import com.example.music.domain.Albums;
import com.example.music.repository.AlbumsRepository;
import com.example.music.service.AlbumsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumsServiceImpl implements AlbumsService {

  private final AlbumsRepository albumsRepository;

  @Override
  public List<Albums> getAlbumsLimit6() {
    return albumsRepository.findAlbumsLimit6();
  }

  @Override
  public List<Albums> getAlbumsOfSong(Long id) {
    return albumsRepository.findAllAlbumsContainSong(id);
  }
}
