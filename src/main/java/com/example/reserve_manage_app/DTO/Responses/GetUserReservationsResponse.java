package com.example.reserve_manage_app.DTO.Responses;

import lombok.Data;

@Data
public class GetUserReservationsResponse {
    /*
     * 予約ID
     */
    private Long reservationId;

    /**
     * 店ID
     */
    private Long restaurantId;

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
