package com.example.music.constants;

public class Constants {
  private Constants() {}

  public static final String authenImage = "authen.png";

  public static final String albums = "albums";

  public static final String artist = "artist";

  public static final String subjectResetPassword = "Spotify reset password";

  public static final String content =
      "<p>Bạn đã reset mật khẩu thành công.</p>\n"
          + "<p>Mật khẩu mới của bạn là <b style=\"color: blue;\">%s</b>.</p>\n"
          + "<p>Vui lòng không tiết lộ cho người lạ.\"</p>";

  public static final String sucessMessage =
      "Reset password thành công! Vui lòng kiểm tra email của bạn.";

  public static final String errorMessage = "Có lỗi xảy ra vui lòng thử lại!";

  public static final String emailNotExist = "Email không tồn tại";

  public static final String ALPHABET =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public static class Role {
    private Role() {}

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
  }
}
