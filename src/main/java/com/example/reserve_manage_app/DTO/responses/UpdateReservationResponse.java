package com.example.reserve_manage_app.dto.responses;

import org.springframework.http.ResponseEntity;

import com.example.reserve_manage_app.Entities.ReservationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateReservationResponse {
    private ReservationEntity data;    
}
