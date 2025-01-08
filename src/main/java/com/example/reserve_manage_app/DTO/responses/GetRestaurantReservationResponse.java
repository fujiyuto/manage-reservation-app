package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.Entities.ReservationEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GetRestaurantReservationResponse extends ApiResponse {

    private List<RestaurantReservationResponse> data;

    public GetRestaurantReservationResponse(List<ReservationEntity> reservationList, String message) {
        // 親クラスのコンストラクタ
        super(message);

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<RestaurantReservationResponse> response = new ArrayList<>();
        for (ReservationEntity reservation : reservationList) {
            RestaurantReservationResponse res = new RestaurantReservationResponse(reservation);
            response.add(res);
        }
        this.data = response;
    }

    public GetRestaurantReservationResponse(List<ReservationEntity> reservationList) {
        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<RestaurantReservationResponse> response = new ArrayList<>();
        for (ReservationEntity reservation : reservationList) {
            RestaurantReservationResponse res = new RestaurantReservationResponse(reservation);
            response.add(res);
        }
        this.data = response;
    }
}

class RestaurantReservationResponse {
    private Long reservationId;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reserveDatetime;

    private int numberOfPeople;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Status status;

    RestaurantReservationResponse (ReservationEntity entity) {
        this.reservationId = entity.getId();
        this.userId = entity.getUser().getId();
        this.reserveDatetime = entity.getReserveDatetime();
        this.numberOfPeople = entity.getNumberOfPeople();
        this.status = entity.getStatus();
    }
}
