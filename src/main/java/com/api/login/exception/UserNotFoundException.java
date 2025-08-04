package com.api.login.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends LoginException{
    public UserNotFoundException(String queryTerm){
        super("Product could not be found",
                String.format("Not found product searching with this term: <%s>", queryTerm),
                HttpStatus.NOT_FOUND);
    }
}
