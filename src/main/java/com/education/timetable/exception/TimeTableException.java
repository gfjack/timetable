package com.education.timetable.exception;


public class TimeTableException extends Exception {

  public TimeTableException(String message) {
    super(message);
  }

  public TimeTableException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
