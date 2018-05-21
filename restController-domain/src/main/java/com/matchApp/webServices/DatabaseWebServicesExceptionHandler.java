package com.matchApp.webServices;

import com.matchApp.DatabaseExceptions.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseWebServicesExceptionHandler {

    @ExceptionHandler({UserAlreadyExistsException.class})
    public String userExists(UserAlreadyExistsException ex) {
        return ex.getMessage();
    }


}
