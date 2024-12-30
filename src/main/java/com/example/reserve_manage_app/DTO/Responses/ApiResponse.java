package com.example.reserve_manage_app.DTO.Responses;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private boolean success;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setSuccess(true);
        response.setMessage("Success");
        return response;
    }

    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
