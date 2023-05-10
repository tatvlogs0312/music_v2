package com.example.music.repository;

import com.example.music.domain.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NationalRepository
    extends JpaRepository<National, Long>, JpaSpecificationExecutor<National> {}
