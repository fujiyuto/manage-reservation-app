package com.example.reserve_manage_app.DTO.Requests;

import lombok.Data;

@Data
public class CreateReservationRequest {
    /**
     * ユーザーID
     */
    private Long userId;

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
     * 特記事項
     */
    private String notes;
}
