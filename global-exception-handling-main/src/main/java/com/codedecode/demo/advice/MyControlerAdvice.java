package com.codedecode.demo.advice;

import com.codedecode.demo.exception.EmptyInputException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControlerAdvice {
    
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
        
        return new  ResponseEntity<String>("input is empty",HttpStatus.BAD_REQUEST);
    }
}
