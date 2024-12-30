package com.example.reserve_manage_app.DTO.Responses;

import lombok.Data;

@Data
public class GetRestaurantReservationResponse {
    /*
     * 予約ID
     */
    private Long reservationId;

    /**
     * ユーザーID
     */
    private Long userId;

    /**
     * 予約日時
     */
    private String reserveDatetime;

    /**
     * 予約人数
     */
    private int numberOfPeople;

    /**
     * 予約状況
     */
    private String status;
}
