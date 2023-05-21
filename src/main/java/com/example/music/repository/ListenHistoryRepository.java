package com.example.music.repository;

import com.example.music.domain.ListenHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenHistoryRepository extends JpaRepository<ListenHistory, Long> {
  List<ListenHistory> findAllByUserId(Long userId);
}
