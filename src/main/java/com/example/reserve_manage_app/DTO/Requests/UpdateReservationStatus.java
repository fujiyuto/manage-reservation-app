package com.example.reserve_manage_app.dto.requests;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.Validations.Annotations.ValidReservationStatus;

import lombok.Data;

@Data
public class UpdateReservationStatus {
    /**
     * 予約状況
     */
    @ValidReservationStatus
    private Status status;
}
