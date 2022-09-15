package com.example.basicauth.controller;

import com.example.basicauth.exception.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity handleMyCustomException() {
        return new ResponseEntity("Eroare custom", HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class, Exception.class})
    public ResponseEntity handleSQLException() {
        return new ResponseEntity("Exceptie SQL", HttpStatus.BAD_REQUEST);
    }

}
