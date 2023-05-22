package com.example.music.repository;

import com.example.music.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE user SET password = :newPassword WHERE email = :email")
  void updatePassword(String email, String newPassword);
}
