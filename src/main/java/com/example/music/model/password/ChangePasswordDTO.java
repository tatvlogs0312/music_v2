package com.example.music.model.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordDTO {
  private String oldPassword;
  private String newPassword;
  private String confirmNewPassword;
}
