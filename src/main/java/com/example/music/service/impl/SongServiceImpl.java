package com.example.music.service.impl;

import com.example.music.domain.Artist;
import com.example.music.domain.ListenHistory;
import com.example.music.domain.Song;
import com.example.music.model.song.SongDTO;
import com.example.music.model.artist.ArtistOfSongDTO;
import com.example.music.model.song.SongHistoryDTO;
import com.example.music.model.song.SongOtherDTO;
import com.example.music.repository.ArtistRepository;
import com.example.music.repository.ListenHistoryRepository;
import com.example.music.repository.SongRepository;
import com.example.music.repository.UserRepository;
import com.example.music.service.SongService;

import com.example.music.service.custom.ArtistCustomService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongServiceImpl implements SongService {

  private final SongRepository songRepository;
  private final ArtistRepository artistRepository;
  private final UserRepository userRepository;
  private final ListenHistoryRepository listenHistoryRepository;
  private final ArtistCustomService artistCustomService;

  @Override
  public SongDTO findSongByID(Long idSong) {
    Optional<Song> songOptional = songRepository.findById(idSong);
    if (songOptional.isEmpty()) {
      return new SongDTO();
    }
    Song song = songOptional.get();
    song.setListens(song.getListens() + 1);
    songRepository.save(song);
    SongDTO songDTO = new SongDTO();
    songDTO.setId(song.getId());
    songDTO.setName(song.getName());
    songDTO.setYear(song.getYear());
    songDTO.setLength(song.getLength());
    songDTO.setUrlImage(song.getUrlImage());
    songDTO.setUrlMp3(song.getUrlMp3());
    List<Artist> artists = artistRepository.findAllByIdSong(idSong);
    String artistList = "";
    if (!artists.isEmpty()) {
      artistList = artists.stream().map(Artist::getName).collect(Collectors.joining(", "));
    }
    songDTO.setArtists(artistList);
    return songDTO;
  }

  @Override
  public List<SongHistoryDTO> findHistory(Long userID) {
    List<ListenHistory> listenHistories = listenHistoryRepository.findAllByUserId(userID);
    if (listenHistories.isEmpty()) {
      return new ArrayList<>();
    }
    List<Long> idSongs = listenHistories.stream().map(ListenHistory::getSongId).toList();
    List<Song> songs = songRepository.findAllByIdIn(idSongs);
    List<SongHistoryDTO> songDTOS = new ArrayList<>();
    List<ArtistOfSongDTO> artistOfSongDTOS = artistCustomService.getArtistsOfSong(idSongs);
    songs.forEach(
        x -> {
          SongHistoryDTO songDTO = new SongHistoryDTO();
          songDTO.setId(x.getId());
          songDTO.setName(x.getName());
          songDTO.setUrlImage(x.getUrlImage());
          songDTO.setLength(x.getLength());
          songDTO.setYear(x.getYear());
          var artists =
              artistOfSongDTOS.stream().filter(a -> a.getSongId().equals(x.getId())).toList();
          String artistList = "";
          if (!artists.isEmpty()) {
            artistList =
                artists.stream().map(ArtistOfSongDTO::getName).collect(Collectors.joining(", "));
          }
          songDTO.setArtists(artistList);
          songDTOS.add(songDTO);
        });
    return songDTOS;
  }

  @Override
  public List<Song> getNewestMusic() {
    return songRepository.findNewestLimit6();
  }

  @Override
  public List<Song> getTrendingMusic() {
    return songRepository.findTrendingLimit6();
  }

  @Override
  public List<SongOtherDTO> getSongOther(Long songID) {
    List<Song> songs = songRepository.getSongOtherLimit6(songID);
    List<Long> idSongs = songs.stream().map(Song::getId).collect(Collectors.toList());
    List<ArtistOfSongDTO> artistOfSongDTOS = artistCustomService.getArtistsOfSong(idSongs);
    List<SongOtherDTO> songOther = new ArrayList<>();
    songs.forEach(
        x -> {
          SongOtherDTO songDTO = new SongOtherDTO();
          songDTO.setId(x.getId());
          songDTO.setName(x.getName());
          songDTO.setUrlImage(x.getUrlImage());
          songDTO.setLength("5:20");
          songDTO.setYear(x.getYear());
          var artists =
              artistOfSongDTOS.stream().filter(a -> a.getSongId().equals(x.getId())).toList();
          String artistList = "";
          if (!artists.isEmpty()) {
            artistList =
                artists.stream().map(ArtistOfSongDTO::getName).collect(Collectors.joining(", "));
          }
          songDTO.setArtists(artistList);
          songOther.add(songDTO);
        });
    return songOther;
  }
}
