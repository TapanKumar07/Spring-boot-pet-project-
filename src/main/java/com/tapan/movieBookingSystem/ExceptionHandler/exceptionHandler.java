package com.tapan.movieBookingSystem.ExceptionHandler;


import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandler {

    @ExceptionHandler(value = movieNotFoundException.class)
    public ResponseEntity HandleMovieNotFoundExceptions() {
        return new ResponseEntity("Movie is not available", HttpStatus.BAD_REQUEST);
    }
}
