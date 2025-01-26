package com.example.reserve_manage_app.dto.query;

import java.time.LocalDate;

import com.example.constants.enums.reservation.Status;

import lombok.Data;

@Data
public class ReservationQueryDto {
    /**
     * ユーザー名
     */
    private String userName;

    /**
     * 店名
     */
    private String restaurantName;

    /**
     * 予約日
     */
    private LocalDate reserveDate;

    /**
     * 予約人数
     */
    private int numberOfPeople;

    /**
     * 予約状況
     */
    private Status status;

    /**
     * 特記事項
     */
    private String notes;

    /**
     * 予約時間（時）
     */
    private int hour;

    /**
     * 予約時間（分）
     */
    private int minute;
}
