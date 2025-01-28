package com.example.reserve_manage_app.exceptions;

public class DataNotFoundException extends RuntimeException  {
    public DataNotFoundException(String message) {
        super(message);
    }
}
