package com.example.music.repository;

import com.example.music.domain.ArtistSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistSongRepository
    extends JpaRepository<ArtistSong, Long>, JpaSpecificationExecutor<ArtistSong> {}
