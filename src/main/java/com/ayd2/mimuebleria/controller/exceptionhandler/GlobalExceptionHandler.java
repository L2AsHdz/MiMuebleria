package com.ayd2.mimuebleria.controller.exceptionhandler;

import com.ayd2.mimuebleria.exceptions.DuplicatedEntityExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatedEntityExeption.class)
    public ResponseEntity<String> handlerDuplicatedException(DuplicatedEntityExeption ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}