package com.education.timetable.exception.courseExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class CourseException extends ResponseStatusException {

    public CourseException(String message) {
        super(HttpStatus.BAD_REQUEST, getMessage(message));
    }

    public CourseException(String message, UUID courseId) {
        super(HttpStatus.BAD_REQUEST, getMessage(message, courseId));
    }

    public static String getMessage(String message) {
        return String.format("CANNOT CREATE COURSE, REASON: %s", message);
    }

    public static String getMessage(String message, UUID courseId) {
        return String.format("CANNOT UPDATE COURSE: %s, REASON: %s", courseId.toString(), message);
    }

}
