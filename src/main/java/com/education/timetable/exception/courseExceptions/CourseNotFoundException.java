package com.education.timetable.exception.courseExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class CourseNotFoundException extends ResponseStatusException {
    public CourseNotFoundException(HttpStatus status) {
        super(status);
    }

    public CourseNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public CourseNotFoundException(UUID courseId) {
        super(HttpStatus.NOT_FOUND, getMessage(courseId));
    }

    public CourseNotFoundException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public CourseNotFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public static String getMessage(UUID courseId) {
        return String.format("COURSE NOT FOUND: %s, REASON: %s", courseId.toString(), "NO SUCH COURSE");
    }
}
