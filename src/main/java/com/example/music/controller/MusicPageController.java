package com.example.music.controller;

import com.example.music.service.AlbumsService;
import com.example.music.service.SongService;
import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicPageController {

  private final UserService userService;

  private final SongService songService;

  private final AlbumsService albumsService;

  @GetMapping("/play")
  public String playMusic(@PathParam("id") Long id, Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("song", songService.findSongByID(id));
    model.addAttribute("songOthers", songService.getSongOther(id));
    model.addAttribute("albums", albumsService.getAlbumsOfSong(id));
    return "music";
  }
}
