package com.example.music.controller;

import com.example.music.model.mail.MailResetDTO;
import com.example.music.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class ApiController {

  private final UserService userService;

  @PutMapping(value = "/send-mail-reset-password", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> sendMail(@RequestBody MailResetDTO mailResetDTO) {
    return new ResponseEntity<>(userService.resetPassword(mailResetDTO), HttpStatus.OK);
  }
}
