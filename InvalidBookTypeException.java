package com.priyanshu.SpringProject.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBookTypeException extends RuntimeException{
    public InvalidBookTypeException(String message) {
        super(message);
    }
}
