package com.example.music.utils;

import com.example.music.constants.Constants;
import java.security.SecureRandom;

public class PasswordUtils {

  private PasswordUtils() {}

  public static String renderStringPassword() {
    String characters = Constants.ALPHABET;
    SecureRandom secureRandom = new SecureRandom();
    StringBuilder sb = new StringBuilder(8);

    for (int i = 0; i < 8; i++) {
      int randomIndex = secureRandom.nextInt(characters.length());
      char randomChar = characters.charAt(randomIndex);
      sb.append(randomChar);
    }

    return sb.toString();
  }
}
