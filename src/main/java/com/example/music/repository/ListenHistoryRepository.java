package com.example.music.repository;

import com.example.music.domain.ListenHistory;
import java.time.LocalDateTime;import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ListenHistoryRepository extends JpaRepository<ListenHistory, Long> {
  @Query("select l from listen_history l where l.userId = ?1 order by l.listenTime DESC")
  List<ListenHistory> findAllByUserIdOrderByListenTimeDesc(Long userId);

  Optional<ListenHistory> findAllByUserIdAndSongId(Long userId, Long songId);

  @Modifying
  @Transactional
  @Query(
      nativeQuery = true,
      value =
          "UPDATE listen_history\n"
              + "SET listen_time = :time\n"
              + "WHERE song_id = :songId\n"
              + "\tAND user_id = :userId")
  void updateTimeListen(Long userId, Long songId, LocalDateTime time);
}
