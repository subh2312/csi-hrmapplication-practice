package com.subhankar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateRecord extends RuntimeException{

    public DuplicateRecord(String message)
    {
        super(message);
    }
}
