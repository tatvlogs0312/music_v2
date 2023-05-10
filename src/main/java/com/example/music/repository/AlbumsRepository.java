package com.example.music.repository;

import com.example.music.domain.Albums;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlbumsRepository
    extends JpaRepository<Albums, Long>, JpaSpecificationExecutor<Albums> {

  List<Albums> findAlbumsLimit6();
}
