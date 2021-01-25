package com.education.timetable.config;

import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Api(hidden = true)
@Controller
public class TimeTableInitController {

  @RequestMapping("/")
  public ModelAndView redirect() {
    return new ModelAndView("index");
  }

  @RequestMapping("/message")
  public ModelAndView toMessage() {
    return new ModelAndView("message");
  }

  @RequestMapping("/class")
  public ModelAndView toClass() {
    return new ModelAndView("class");
  }

  @RequestMapping("/model")
  public ModelAndView toModel() {
    return new ModelAndView("model");
  }

  @RequestMapping("/hello")
  public void get(HttpServletResponse response) {
    try{
      String path = ResourceUtils.getURL("classpath:").getPath();
      String finalPath = path + "templates/index.html";
      File file = new File(finalPath);
      InputStream in = new FileInputStream(file);
      OutputStream out = response.getOutputStream();
      byte[] buffer = IOUtils.toByteArray(in);
      out.write(buffer, 0, buffer.length);
    } catch (Exception ignored) {
    }
  }

}
