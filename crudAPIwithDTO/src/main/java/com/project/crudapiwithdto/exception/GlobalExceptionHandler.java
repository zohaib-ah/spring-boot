package com.project.crudapiwithdto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(UserNotFoundException userNotFoundException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                userNotFoundException.getMessage(),
                webRequest.getDescription(false), "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailExitException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(EmailExitException emailExitException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                emailExitException.getMessage(),
                webRequest.getDescription(false), "EMAIL_ALREADY_EXITS "
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                exception.getMessage(),
                webRequest.getDescription(false), "INTERNAL_SERVER_ERROR "
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
