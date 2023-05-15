package com.example.music.service;

import com.example.music.domain.Song;
import com.example.music.model.song.SongDTO;
import com.example.music.model.song.SongHistoryDTO;
import com.example.music.model.song.SongOtherDTO;
import java.util.List;

public interface SongService {
  SongDTO findSongByID(Long idSong);

  List<SongHistoryDTO> findHistory(Long userID);

  List<Song> getNewestMusic();

  List<Song> getTrendingMusic();

  List<SongOtherDTO> getSongOther(Long songID);
}
