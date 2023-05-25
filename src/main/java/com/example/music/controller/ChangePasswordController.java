package com.example.music.controller;

import com.example.music.model.mail.MailResetDTO;
import com.example.music.model.password.ChangePasswordDTO;
import com.example.music.service.UserService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/change")
@RequiredArgsConstructor
public class ChangePasswordController {
  private final UserService userService;

  @GetMapping
  public String getChangePasswordForm(Model model) {
    model.addAttribute("changePassword", new ChangePasswordDTO());
    return "change-password";
  }

  @PostMapping
  public String changePassword(
      @ModelAttribute("changePassword") ChangePasswordDTO changePasswordDTO,
      Model model,
      HttpServletRequest request) {
    String email = request.getUserPrincipal().getName();
    model.addAttribute("changePassword", new ChangePasswordDTO());
    model.addAttribute("message", userService.changePassword(changePasswordDTO, email));
    return "change-password";
  }
}
