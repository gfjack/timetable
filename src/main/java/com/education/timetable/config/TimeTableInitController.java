package com.education.timetable.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTableInitController {

  @RequestMapping("/")
  public String redirect() {
    return "hello world";
  }
}
