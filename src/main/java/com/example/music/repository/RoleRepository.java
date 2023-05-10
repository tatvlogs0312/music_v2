package com.example.music.repository;

import com.example.music.domain.Role;
import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
