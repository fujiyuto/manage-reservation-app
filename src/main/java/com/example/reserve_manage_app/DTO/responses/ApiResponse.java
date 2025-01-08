package com.example.reserve_manage_app.dto.responses;

import lombok.Data;

@Data
public class ApiResponse {
    private String message = "";

    ApiResponse(String message) {
        this.message = message;
    }

    ApiResponse() {}
}
