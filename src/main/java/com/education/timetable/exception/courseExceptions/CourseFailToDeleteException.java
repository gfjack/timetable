package com.education.timetable.exception.courseExceptions;

import com.education.timetable.config.StringResources;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class CourseFailToDeleteException extends ResponseStatusException {

  public CourseFailToDeleteException(UUID courseId, String reason) {
    super(HttpStatus.BAD_REQUEST, getMessage(courseId, reason));
  }

  public static String getMessage(UUID courseId, String message) {
    return String.format(StringResources.getString("FAILED.TO.DELETE.COURSE"), courseId, message);
  }
}
