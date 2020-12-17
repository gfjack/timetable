package com.education.timetable;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com")
@EnableJpaRepositories(basePackages = "com.education.timetable.repository")
@EntityScan("com.education.timetable.model.entity")
@SpringBootApplication
@EnableMethodCache(basePackages = "com.education.timetable")
@EnableCreateCacheAnnotation
public class TimetableApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(TimetableApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(TimetableApplication.class);
  }

  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
    pool.setCorePoolSize(30);
    pool.setMaxPoolSize(200);
    pool.setWaitForTasksToCompleteOnShutdown(true);
    pool.setQueueCapacity(20000);
    return pool;
  }
}
