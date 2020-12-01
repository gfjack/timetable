package com.education.timetable.exception.courseExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class CourseFailToDeleteException extends ResponseStatusException {

    public CourseFailToDeleteException(UUID courseId, String reason) {
        super(HttpStatus.BAD_REQUEST, getMessage(courseId, reason));
    }

    public static String getMessage(UUID courseId, String message) {
        return String.format("FAILED TO DELETE COURSE: %s, REASON: %s", courseId, message);
    }

    public static String getMessage(String message) {
        return String.format("FAILED TO DELETE COURSE, REASON: %s", message);
    }

}
