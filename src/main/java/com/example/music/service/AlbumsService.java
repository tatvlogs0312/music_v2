package com.example.music.service;

import com.example.music.domain.Albums;
import java.util.List;

public interface AlbumsService {
  List<Albums> getAlbumsLimit6();
}
