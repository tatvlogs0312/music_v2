package com.example.music.service.impl;

import com.example.music.domain.Artist;
import com.example.music.domain.ListenHistory;
import com.example.music.domain.Song;
import com.example.music.model.artist.ArtistDTO;
import com.example.music.model.song.SongDTO;
import com.example.music.model.artist.ArtistOfSongDTO;
import com.example.music.model.song.SongHistoryDTO;
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
    SongDTO songDTO = new SongDTO();
    songDTO.setId(song.getId());
    songDTO.setName(song.getName());
    songDTO.setYear(song.getYear());
    songDTO.setLength(song.getLength());
    songDTO.setUrlImage(song.getUrlImage());
    List<Artist> artists = artistRepository.findAllByIdSong(idSong);
    List<ArtistDTO> artistDTOS = new ArrayList<>();
    if (!artists.isEmpty()) {
      artistDTOS = artists.stream().map(ArtistDTO::new).toList();
    }
    songDTO.setArtists(artistDTOS);
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
              artistOfSongDTOS.stream()
                  .filter(a -> a.getSongId().equals(x.getId()))
                  .collect(Collectors.toList());
          songDTO.setArtists(artists);
          songDTOS.add(songDTO);
        });
    return songDTOS;
  }
}
