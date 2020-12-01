package com.education.timetable.config;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Api(hidden = true)
@Controller
public class TimeTableInitController {

  @RequestMapping("/")
  public ModelAndView redirect() {
    return new ModelAndView("index");
  }

//  @RequestMapping("/error")
//  public String  handleError(HttpServletRequest request, Model model) {
//
//    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//    Object errorException = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//    Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
//
//    model.addAttribute("exception", errorException);
//    model.addAttribute("message", errorMessage);
//    model.addAttribute("code", status);
//    return "error";
//  }
//
//  @Override
//  public String getErrorPath() {
//    return "/error";
//  }
}
