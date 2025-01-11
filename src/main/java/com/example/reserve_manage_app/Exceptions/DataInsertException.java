package com.example.reserve_manage_app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DataInsertException extends Exception {

    // レコード作成エラー
    DataInsertException(String message) {
        super(message);
    } 
}
