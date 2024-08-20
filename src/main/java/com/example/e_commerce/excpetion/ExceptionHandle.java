package com.example.e_commerce.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> argumentNotValid (MethodArgumentNotValidException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionReponse> custumExHandler(CustomException customEx){
        return new ResponseEntity<ExceptionReponse>(new ExceptionReponse(customEx.getMessage(),
                customEx.getStatus(), LocalDateTime.now()),customEx.getStatus());

    }
}
