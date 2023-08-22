package com.example.assessmentserver.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = InfoNotFoundException.class)
    public ResponseEntity<String> catchInfoNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
