package com.subhankar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeRecordNotFound extends RuntimeException{

    public EmployeeRecordNotFound(String message)
    {
        super(message);
    }
}
