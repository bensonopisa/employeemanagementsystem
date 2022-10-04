package com.stackdevs.EMS.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DataConflictException extends RuntimeException{
    public DataConflictException(String message) {
        super(message);
    }
}
