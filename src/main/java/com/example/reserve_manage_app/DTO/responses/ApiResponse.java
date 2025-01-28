package com.example.reserve_manage_app.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    ApiResponse() {}
}
