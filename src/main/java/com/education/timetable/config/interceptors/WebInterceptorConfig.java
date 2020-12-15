package com.education.timetable.config.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class WebInterceptorConfig extends WebMvcConfigurationSupport {

  @Resource private AuthInterceptor authInterceptor;

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor).addPathPatterns("/v1/**");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry
        .addResourceHandler("/**")
        .addResourceLocations("classpath:/static/")
        .addResourceLocations("classpath:/META-INF/resources");
  }
}
