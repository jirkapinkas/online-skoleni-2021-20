package com.example.hellospring.controller;

import com.example.hellospring.pojo.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppRestControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Message> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Message("Some error message", HttpStatus.BAD_REQUEST.value()));
    }

}
