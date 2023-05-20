package com.example.music.repository.custom.implement;

import com.example.music.model.artist.ArtistOfSongDTO;
import com.example.music.repository.custom.ArtistRepositoryCustom;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistRepositoryCustomImpl implements ArtistRepositoryCustom {
  private final EntityManager entityManager;

  @Override
  public List<ArtistOfSongDTO> getAllArtistOfSongData(List<Long> idSong) {
    String sql =
              "SELECT a.id,a.name,a.url_avatar,as2.song_id \n"
            + "FROM artist a \n"
            + "JOIN artist_song as2 ON a.id = as2.artist_id \n"
            + "WHERE as2.song_id in (:idSong)";
    Query query = entityManager.createNativeQuery(sql);
    query.setParameter("idSong", idSong);
    List<Object[]> result = query.getResultList();
    if (!result.isEmpty()) {
      List<ArtistOfSongDTO> artistOfSongDTOS = new ArrayList<>();
      result.forEach(x -> artistOfSongDTOS.add(new ArtistOfSongDTO(x)));
      return artistOfSongDTOS;
    }
    return new ArrayList<>();
  }
}
