package com.example.music.controller;

import com.example.music.domain.User;
import com.example.music.model.user.UserRegisterDTO;
import com.example.music.service.UserService;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") UserRegisterDTO userRegisterDTO, Model model) {
        Optional<User> user = userService.findByEmail(userRegisterDTO.getEmail());
        if (user.isPresent()) {
            model.addAttribute("error", "Email đã tồn tại");
        } else if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
            model.addAttribute("error", "Mật khẩu không trùng khớp");
        } else {
            userService.saveUser(userRegisterDTO);
            model.addAttribute("success", "Đăng ký tài khoản thành công !");
        }

        model.addAttribute("user", new UserRegisterDTO());
        return "register";
    }

}
