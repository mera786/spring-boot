package com.app.exception;


import com.app.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), "User API Error");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Generic Exception (Optional but good practice)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception ex) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                "Something went wrong",
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

