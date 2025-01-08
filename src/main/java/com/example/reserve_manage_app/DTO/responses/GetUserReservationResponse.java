package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDateTime;
import java.util.*;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.Entities.ReservationEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GetUserReservationResponse extends ApiResponse {
    private List<UserReservationResponse> data;

    // レスポンスにメッセージを指定する場合
    public GetUserReservationResponse(List<ReservationEntity> reservation, String message) {
        // 親クラスのコンストラクタ
        super(message);

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<UserReservationResponse> response = new ArrayList<>();
        for (ReservationEntity entity : reservation) {
            UserReservationResponse res = new UserReservationResponse(entity);
            response.add(res);
        }
        this.data = response;
    }

    // レスポンスにメッセージを指定せず、データのみを返す場合
    public GetUserReservationResponse(List<ReservationEntity> reservation) {

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<UserReservationResponse> response = new ArrayList<>();
        for (ReservationEntity entity : reservation) {
            UserReservationResponse res = new UserReservationResponse(entity);
            response.add(res);
        }
        this.data = response;
    }
}

class UserReservationResponse {
    private Long reservationId;

    private Long restaurantId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reserveDatetime;

    private int numberOfPeople;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Status status;

    UserReservationResponse (ReservationEntity entity) {
        this.reservationId = entity.getId();
        this.restaurantId = entity.getRestaurant().getId();
        this.reserveDatetime = entity.getReserveDatetime();
        this.numberOfPeople = entity.getNumberOfPeople();
        this.status = entity.getStatus();
    }
}
