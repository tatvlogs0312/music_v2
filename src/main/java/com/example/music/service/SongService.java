package com.example.music.service;

import com.example.music.model.song.SongDTO;
import com.example.music.model.song.SongHistoryDTO;
import java.util.List;

public interface SongService {
  SongDTO findSongByID(Long idSong);

  List<SongHistoryDTO> findHistory(Long userID);
}
