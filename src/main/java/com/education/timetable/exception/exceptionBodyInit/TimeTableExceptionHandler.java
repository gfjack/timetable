package com.education.timetable.exception.exceptionBodyInit;

import com.education.timetable.exception.ObjectNotFoundException;
import com.education.timetable.exception.TimeTableException;
import com.education.timetable.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@EnableWebMvc
@ControllerAdvice
public class TimeTableExceptionHandler {

    @ExceptionHandler(value = TimeTableException.class)
    public ResponseEntity<Object> bizExceptionHandler(HttpServletRequest req, TimeTableException e){
        HttpStatus httpStatus = null;
        try{
            httpStatus = HttpStatus.valueOf(e.getErrorCode());
        } catch (Exception ignored) {
        } finally{
            if (null == httpStatus) {
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }
        return new ResponseEntity<>(ResultBody.error(e.getErrorCode(),e.getErrorMsg()), httpStatus);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> exceptionHandler(HttpServletRequest req, NullPointerException e){
        return new ResponseEntity<>(ResultBody.error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity<Object> notFoundHandler(ObjectNotFoundException e){
        return new ResponseEntity<>(ResultBody.error(404, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorized(UnauthorizedException e) {
        return new ResponseEntity<>(ResultBody.error(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public String hand() {
        return "eee";
    }

}
