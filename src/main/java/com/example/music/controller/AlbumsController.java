package com.example.music.controller;

import com.example.music.constants.Constants;
import com.example.music.service.AlbumsService;
import com.example.music.service.SongService;
import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumsController {

  private final AlbumsService albumsService;

  private final SongService songService;

  private final UserService userService;

  @GetMapping()
  public String getAllAlbums(Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute(Constants.albums, albumsService.getAlbumsData());
    return "albums";
  }

    @GetMapping("/details/{id}")
  public String getAlbumsDetail(@PathVariable Long id, Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute(Constants.albums, songService.getAllByAlbums(id));
    return "albums-details";
  }
}
