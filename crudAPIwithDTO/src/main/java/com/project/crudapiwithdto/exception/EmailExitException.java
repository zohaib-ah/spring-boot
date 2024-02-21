package com.project.crudapiwithdto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailExitException extends RuntimeException{

    private String  message;
    public EmailExitException(String message){
        super(message);
    }
}
