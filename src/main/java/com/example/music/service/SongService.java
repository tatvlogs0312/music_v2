package com.example.music.service;

import com.example.music.domain.Song;
import com.example.music.model.albums.AlbumsDetailsDTO;
import com.example.music.model.artist.ArtistDetailsDTO;
import com.example.music.model.search.SearchDTO;
import com.example.music.model.song.SongDTO;
import com.example.music.model.song.SongDataDTO;
import com.example.music.model.song.SongHistoryDTO;
import com.example.music.model.song.SongOtherDTO;
import java.util.List;

public interface SongService {
  SongDTO findSongByID(Long idSong);

  List<SongHistoryDTO> findHistory(Long userID);

  List<Song> getNewestMusic();

  List<Song> getTrendingMusic();

  List<SongOtherDTO> getSongOther(Long songID);

  AlbumsDetailsDTO getAllByAlbums(Long idAlbums);

  ArtistDetailsDTO getAllByArtist(Long idArtist);

  List<SongOtherDTO> getSongOtherInAlbums(Long songID, Long albumsID);

  List<SongDTO> findSongByKeyword(SearchDTO searchDTO);

  List<SongDataDTO> getAllSongData();
}
