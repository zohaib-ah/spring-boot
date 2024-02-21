package com.project.task.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotfoundException extends RuntimeException{




    public TaskNotfoundException(String message) {
        super(message);
    }

}
