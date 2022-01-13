package com.subhankar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidLoginCredentials extends RuntimeException{
    public InvalidLoginCredentials(String message)
    {
        super(message);
    }
}
