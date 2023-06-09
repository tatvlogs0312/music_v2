package com.example.music.controller;

import com.example.music.service.AlbumsService;
import com.example.music.service.ArtistService;
import com.example.music.service.SongService;
import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final SongService songService;
  private final UserService userService;
  private final ArtistService artistService;
  private final AlbumsService albumsService;

  @GetMapping()
  public String home(Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
      model.addAttribute("histories", songService.findHistory(user.getId()));
    }
    model.addAttribute("songs", songService.getTrendingMusic());
    model.addAttribute("artists", artistService.getArtistLimit10());
    model.addAttribute("albums", albumsService.getAlbumsLimit6());
    return "index";
  }
}
