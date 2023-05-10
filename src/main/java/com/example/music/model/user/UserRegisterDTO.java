package com.example.music.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String repeatPassword;
}
