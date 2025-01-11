package com.example.reserve_manage_app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DataNotFoundException extends RuntimeException  {
    public DataNotFoundException(String message) {
        super(message);
    }
}
