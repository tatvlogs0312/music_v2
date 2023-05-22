package com.example.music.service.impl;

import com.example.music.constants.Constants;
import com.example.music.domain.ListenHistory;
import com.example.music.domain.Role;
import com.example.music.domain.User;
import com.example.music.model.mail.MailResetDTO;
import com.example.music.model.user.UserRegisterDTO;
import com.example.music.model.user.Me;
import com.example.music.repository.ListenHistoryRepository;
import com.example.music.repository.RoleRepository;
import com.example.music.repository.UserRepository;
import com.example.music.service.UserService;
import com.example.music.utils.PasswordUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final RoleRepository repository;

  private final BCryptPasswordEncoder passwordEncoder;

  private final ListenHistoryRepository listenHistoryRepository;

  private final JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String myEmail;

  @Override
  public void saveUser(UserRegisterDTO userRegisterDTO) {
    User newUser = new User();
    newUser.setFirstName(userRegisterDTO.getFirstName());
    newUser.setLastName(userRegisterDTO.getLastName());
    newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
    newUser.setEmail(userRegisterDTO.getEmail());
    newUser.setAvatarUser(Constants.authenImage);
    Role role = repository.findByName(Constants.Role.USER);
    newUser.setRoles(List.of(role));
    userRepository.save(newUser);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Me me(String email) {
    Optional<User> userOptional = userRepository.findByEmail(email);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      Me me = new Me();
      me.setId(user.getId());
      me.setFirstName(user.getFirstName());
      me.setLastName(user.getLastName());
      me.setAvatarUrl(user.getAvatarUser());
      me.setEmail(user.getEmail());
      return me;
    }
    return null;
  }

  @Override
  public void saveHistory(Long idUser, Long idSong) {
    CompletableFuture.runAsync(
        () -> {
          Optional<ListenHistory> listenHistoryOptional =
              listenHistoryRepository.findAllByUserIdAndSongId(idUser, idSong);
          if (listenHistoryOptional.isPresent()) {
            listenHistoryRepository.updateTimeListen(idUser, idSong, LocalDateTime.now());
          } else {
            listenHistoryRepository.save(new ListenHistory(idSong, idUser));
          }
        });
  }

  @Override
  public String resetPassword(MailResetDTO mailResetDTO) {
    try {
      Optional<User> userOptional = userRepository.findByEmail(mailResetDTO.getEmail());
      if (userOptional.isPresent()) {
        CompletableFuture.runAsync(
            () -> {
              String password = PasswordUtils.renderStringPassword();
              sendMailToUser(mailResetDTO.getEmail(), password);
              userRepository.updatePassword(
                  mailResetDTO.getEmail(), passwordEncoder.encode(password));
            });

        return Constants.sucessMessage;
      }
      return Constants.emailNotExist;
    } catch (Exception e) {
      return Constants.errorMessage;
    }
  }

  private void sendMailToUser(String email, String password) {
    MimeMessagePreparator message =
        mimeMessage -> {
          MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
          messageHelper.setFrom(myEmail);
          messageHelper.setTo(email);
          messageHelper.setSubject(Constants.subjectResetPassword);
          messageHelper.setText(String.format(Constants.content, password), true);
        };
    javaMailSender.send(message);
  }
}
