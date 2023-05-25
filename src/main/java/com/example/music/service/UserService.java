package com.example.music.service;

import com.example.music.domain.User;
import com.example.music.model.mail.MailResetDTO;
import com.example.music.model.password.ChangePasswordDTO;import com.example.music.model.user.UserRegisterDTO;
import com.example.music.model.user.Me;
import java.util.Optional;

public interface UserService {
  void saveUser(UserRegisterDTO userRegisterDTO);

  Optional<User> findByEmail(String email);

  Me me(String email);

  void saveHistory(Long idUser, Long idSong);

  String resetPassword(MailResetDTO mailResetDTO);

  String changePassword(ChangePasswordDTO changePasswordDTO, String email);
}
