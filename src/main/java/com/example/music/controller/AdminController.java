package com.example.music.controller;

import com.example.music.model.song.SongDataDTO;
import com.example.music.service.DataService;
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
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

  private final UserService userService;

  private final DataService dataService;

  private final SongService songService;

  @GetMapping
  public String adminPage(Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("number", dataService.getDataNumber());
    model.addAttribute("songs", songService.getAllSongData());
    model.addAttribute("artistsData", dataService.getArtistData());
    return "admin";
  }
}
