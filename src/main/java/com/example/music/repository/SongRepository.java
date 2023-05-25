package com.example.music.repository;

import com.example.music.domain.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {
  List<Song> findAllByIdIn(List<Long> id);

  @Query(
      nativeQuery = true,
      value =
          "SELECT s.* FROM song s \n"
              + "JOIN listen_history lh ON s.id = lh.song_id \n"
              + "WHERE lh.user_id = :userId\n"
              + "ORDER BY lh.listen_time DESC\n"
              + "LIMIT 6")
  List<Song> findHistoryLimit6(Long userId);

  @Query(nativeQuery = true, value = "SELECT s.* FROM song s ORDER BY s.create_time DESC LIMIT 6")
  List<Song> findNewestLimit6();

  @Query(nativeQuery = true, value = "SELECT s.* FROM song s ORDER BY s.listens DESC LIMIT 8")
  List<Song> findTrendingLimit6();

  @Query(
      nativeQuery = true,
      value =
          "SELECT s.* FROM song s\n"
              + "JOIN artist_song as3 ON as3.song_id = s.id \n"
              + "WHERE as3.artist_id in (SELECT as2.artist_id FROM artist_song as2 WHERE as2.song_id = :songID)\n"
              + "AND s.id <> :songID\n"
              + "ORDER BY RAND() LIMIT 6")
  List<Song> getSongOtherLimit6(Long songID);

  @Query(
      nativeQuery = true,
      value =
          "SELECT * FROM song s  \n"
              + "JOIN albums_song as2 ON as2.song_id = s.id \n"
              + "                     AND as2.albums_id = :idAlbums\n"
              + "ORDER BY s.name;")
  List<Song> getAllByAlbums(Long idAlbums);

  @Query(
      nativeQuery = true,
      value =
          "SELECT * FROM song s  \n"
              + "JOIN artist_song as2 ON as2.song_id = s.id \n"
              + "                     AND as2.artist_id = :idArtist\n"
              + "ORDER BY s.name")
  List<Song> getAllByArtist(Long idArtist);

  @Query(
      nativeQuery = true,
      value =
          "SELECT * FROM song s  \n"
              + "JOIN albums_song as2 ON as2.song_id = s.id \n"
              + "                     AND as2.albums_id = :idAlbums\n"
              + "WHERE as2.id <> :idSong\n"
              + "ORDER BY s.name")
  List<Song> getOtherSongInAlbums(Long idSong, Long idAlbums);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE song SET listens = :listens WHERE id = :id")
  void updateListen(Integer listens, Long id);

  @Query(
      nativeQuery = true,
      value =
          "SELECT DISTINCT s.* FROM song s  \n"
              + "JOIN artist_song as2 ON as2.song_id = s.id \n"
              + "JOIN artist a ON a.id = as2.artist_id \n"
              + "WHERE s.value_search like CONCAT('%',:keyword,'%') \n"
              + "OR a.value_to_search like CONCAT('%',:keyword,'%') \n"
              + "ORDER BY s.name ")
  List<Song> getAllByKeyword(String keyword);
}
