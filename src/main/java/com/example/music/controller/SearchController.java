package com.example.music.controller;

import com.example.music.model.mail.MailResetDTO;
import com.example.music.model.search.SearchDTO;
import com.example.music.service.SongService;import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

  private final UserService userService;

  private final SongService songService;

  @GetMapping()
  public String searchMusicForm(Model model, HttpServletRequest header) {
    if (Objects.nonNull(header.getUserPrincipal())) {
      String email = header.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("request", new SearchDTO());
    return "search";
  }

  @PostMapping()
  public String searchMusic(
      @ModelAttribute("request") SearchDTO searchDTO, Model model, HttpServletRequest header) {
    if (Objects.nonNull(header.getUserPrincipal())) {
      String email = header.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    var songs = songService.findSongByKeyword(searchDTO);
    if(!songs.isEmpty()){
      model.addAttribute("songs", songs);
    } else {
      model.addAttribute("empty","");
    }
    return "search";
  }
}
