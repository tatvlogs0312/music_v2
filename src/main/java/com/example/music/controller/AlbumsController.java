package com.example.music.controller;

import com.example.music.service.AlbumsService;
import com.example.music.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumsController {

  private final AlbumsService albumsService;

  private final UserService userService;

  @GetMapping()
  public String getAllArtist(Model model, HttpServletRequest request) {
    if (Objects.nonNull(request.getUserPrincipal())) {
      String email = request.getUserPrincipal().getName();
      var user = userService.me(email);
      model.addAttribute("user", user);
    }
    model.addAttribute("albums", albumsService.getAlbumsData());
    return "albums";
  }
}
