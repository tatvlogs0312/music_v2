package com.example.music.controller;

import com.example.music.model.mail.MailResetDTO;
import com.example.music.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reset")
@RequiredArgsConstructor
public class ResetPasswordController {

  private final UserService userService;

  @GetMapping()
  public String resetPassword(Model model) {
    model.addAttribute("user", new MailResetDTO());
    return "reset-password";
  }

  @PostMapping()
  public String reset(@ModelAttribute("user") MailResetDTO mailResetDTO, Model model) {
    model.addAttribute("user", new MailResetDTO());
    model.addAttribute("success", userService.resetPassword(mailResetDTO));
    return "reset-password";
  }
}
