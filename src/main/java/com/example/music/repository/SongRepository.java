package com.example.music.repository;

import com.example.music.domain.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {
  List<Song> findAllByIdIn(List<Long> id);

  @Query(nativeQuery = true, value = "SELECT s.* FROM song s ORDER BY s.create_time LIMIT 6")
  List<Song> findNewestLimit6();

  @Query(nativeQuery = true, value = "SELECT s.* FROM song s ORDER BY s.listens LIMIT 6")
  List<Song> findTrendingLimit6();
}
