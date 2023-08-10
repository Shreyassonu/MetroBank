package com.maveric.AccountService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ExceptionHandler {


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleInvalidArgumentException(MethodArgumentNotValidException ex) {


        Map<String, String> errorMap = new HashMap();


        ex.getBindingResult().getFieldErrors().forEach(error -> {


            errorMap.put(error.getField(), error.getDefaultMessage());


        });


        return errorMap;


    }



}
