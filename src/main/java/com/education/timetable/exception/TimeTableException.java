package com.education.timetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TimeTableException extends ResponseStatusException {

  public TimeTableException(HttpStatus status, String message, Throwable throwable) {
    super(status, message, throwable);
  }

  public TimeTableException(HttpStatus status, String message) {
    super(status, message);
  }

  public TimeTableException(String message) {
    super(HttpStatus.MULTI_STATUS, message);
  }

  public TimeTableException(int rawStatusCode, String reason, Throwable cause) {
    super(rawStatusCode, reason, cause);
  }
}
