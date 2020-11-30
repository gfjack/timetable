package com.education.timetable.config;

import io.swagger.annotations.Api;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Api(hidden = true)
@Controller
public class TimeTableInitController implements ErrorController {

  @RequestMapping("/")
  public ModelAndView redirect() {
    return new ModelAndView("index");
  }

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, Model model) {
    return "error";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
