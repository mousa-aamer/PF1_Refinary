package com.mousa.demo.RefineryDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Object> taskException(Exception e) {
        System.out.println(e);
        var response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        return response;
    }
}
