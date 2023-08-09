package com.maveric.AccountService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountIdNotFoundException extends RuntimeException{
    private String message;

    public AccountIdNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
