package com.example.music.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Me {
  private Long id;
  private String firstName;
  private String lastName;
  private String avatarUrl;
  private String email;
}
