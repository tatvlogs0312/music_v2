package com.example.music.repository;

import com.example.music.domain.AlbumsSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlbumsSongRepository
    extends JpaRepository<AlbumsSong, Long>, JpaSpecificationExecutor<AlbumsSong> {}
