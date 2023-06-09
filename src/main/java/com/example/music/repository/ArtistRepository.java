package com.example.music.repository;

import com.example.music.domain.Artist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository
    extends JpaRepository<Artist, Long>, JpaSpecificationExecutor<Artist> {

  @Query(nativeQuery = true, value = "SELECT a.* FROM artist a ORDER BY a.create_date LIMIT 10")
  List<Artist> findNewestLimit10();

  @Query(
      value =
          "SELECT a.* \n"
              + "FROM artist a \n"
              + "JOIN artist_song as2 ON a.id = as2.artist_id \n"
              + "WHERE as2.song_id = :idSong",
      nativeQuery = true)
  List<Artist> findAllByIdSong(Long idSong);

  @Query(nativeQuery = true, value = "SELECT * FROM artist a ORDER BY create_date DESC")
  List<Artist> findAllData();
}
