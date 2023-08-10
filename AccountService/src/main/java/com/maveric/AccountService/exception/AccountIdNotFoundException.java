package com.maveric.AccountService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccountIdNotFoundException extends Exception {
    private String message;

    public AccountIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}





