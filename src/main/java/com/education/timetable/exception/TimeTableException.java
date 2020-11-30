package com.education.timetable.exception;


import org.springframework.http.HttpStatus;

public class TimeTableException extends RuntimeException {

  public TimeTableException(String message) {
    this(HttpStatus.BAD_REQUEST.getReasonPhrase(), message);
  }

  public TimeTableException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public TimeTableException(String code, String message) {
    super(message, new Throwable(code));
  }
}
