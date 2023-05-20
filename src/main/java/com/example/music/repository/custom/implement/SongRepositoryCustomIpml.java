package com.example.music.repository.custom.implement;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SongRepositoryCustomIpml {
  private final EntityManager entityManager;
}
