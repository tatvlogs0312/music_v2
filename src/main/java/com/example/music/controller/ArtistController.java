package com.example.music.controller;

import com.example.music.service.ArtistService;
import com.example.music.service.SongService;import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

  private final ArtistService artistService;

  private final SongService songService;

  private final UserService userService;

  @GetMapping()
  public String getAllArtist(Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("artists", artistService.getAllArtistData());
    return "artist";
  }

  @GetMapping("/details/{id}")
  public String getArtistDetail(@PathVariable Long id, Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("artist",songService.getAllByArtist(id));
    return "artist-details";
  }
}
