package com.project.crudapiwithdto.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> error = new HashMap<>();
        List<ObjectError> errorlist = ex.getBindingResult().getAllErrors();

        errorlist.forEach((error1) ->{
                String fieldName = ((FieldError) error1).getField();
                String message = error1.getDefaultMessage();
                error.put(fieldName, message);

    });
            return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
