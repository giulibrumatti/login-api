package com.api.login.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LoginException extends RuntimeException{
    protected String title;
    protected HttpStatus status;

    public LoginException(String title, String message, HttpStatus status){
        super(message);
        this.title = title;
        this.status = status;
    }
}
