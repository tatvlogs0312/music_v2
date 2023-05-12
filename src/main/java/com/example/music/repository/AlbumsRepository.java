package com.example.music.repository;

import com.example.music.domain.Albums;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AlbumsRepository
    extends JpaRepository<Albums, Long>, JpaSpecificationExecutor<Albums> {

  @Query(nativeQuery = true, value = "SELECT * FROM albums a ORDER BY a.create_at LIMIT 6")
  List<Albums> findAlbumsLimit6();
}
