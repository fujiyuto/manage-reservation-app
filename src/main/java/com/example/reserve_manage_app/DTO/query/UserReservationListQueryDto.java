package com.example.reserve_manage_app.dto.query;

import java.time.LocalDate;

import com.example.constants.enums.reservation.Status;

import lombok.Data;

@Data
public class UserReservationListQueryDto {
    /**
     * 予約ID
     */
    private Long reservationId;

    /**
     * 店名
     */
    private String restaurantName;

    /**
     * 予約日
     */
    private LocalDate reserveDate;

    /**
     * 予約時間（時）
     */
    private int hour;

    /**
     * 予約時間（分）
     */
    private int minute;

    /**
     * 予約人数
     */
    private int numberOfPeople;

    /**
     * 予約状況
     */
    private Status status;
}
