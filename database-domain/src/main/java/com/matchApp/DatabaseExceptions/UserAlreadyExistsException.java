package com.matchApp.DatabaseExceptions;

import org.springframework.stereotype.Component;

@Component
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("User with provided data already exits");
    }

}
