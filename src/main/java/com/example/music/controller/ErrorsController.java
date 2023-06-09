package com.example.music.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorsController implements ErrorController {

  @GetMapping
  public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());

      if (statusCode == HttpStatus.NOT_FOUND.value()) {
        return "404";
      } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
        return "403";
      } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
        return "401";
      }
//      else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//        return "500";
//      }
    }
    return "error";
  }
}
