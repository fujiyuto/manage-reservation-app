package com.example.reserve_manage_app.Exceptions;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.reserve_manage_app.dto.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // DBエラー
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiResponse> handleSqlError(SQLException e) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse("Database Error: " + e.getMessage()));
    }

    // データ取得できなかった時のエラー
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiResponse> handleDataNotFountError(DataNotFoundException e) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse("Request data not found."));
    }

    // レコード作成エラー
    @ExceptionHandler(DataInsertException.class)
    public ResponseEntity<ApiResponse> handleDataInsertError(DataInsertException e) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse("Data can't inserted."));
    }

    // レコード更新エラー
    @ExceptionHandler(DataUpdateException.class)
    public ResponseEntity<ApiResponse> handleDataUpdateError(DataUpdateException e) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ApiResponse("Data can't updated."));
    }
}
