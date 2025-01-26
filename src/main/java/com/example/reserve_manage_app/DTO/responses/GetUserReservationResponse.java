package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.dto.query.UserReservationListQueryDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GetUserReservationResponse extends ApiResponse {
    private List<UserReservationResponse> data;

    // レスポンスにメッセージを指定する場合
    public GetUserReservationResponse(List<UserReservationListQueryDto> reservation, String message) {
        // 親クラスのコンストラクタ
        super(message);

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<UserReservationResponse> response = new ArrayList<>();
        for (UserReservationListQueryDto entity : reservation) {
            UserReservationResponse res = new UserReservationResponse(entity);
            response.add(res);
        }
        this.data = response;
    }

    // レスポンスにメッセージを指定せず、データのみを返す場合
    public GetUserReservationResponse(List<UserReservationListQueryDto> reservation) {

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<UserReservationResponse> response = new ArrayList<>();
        for (UserReservationListQueryDto entity : reservation) {
            UserReservationResponse res = new UserReservationResponse(entity);
            response.add(res);
        }
        this.data = response;
    }
}

class UserReservationResponse {
    private Long reservationId;

    private String restaurantName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reserveDatetime;

    private int numberOfPeople;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Status status;

    UserReservationResponse (UserReservationListQueryDto dto) {
        this.reservationId = dto.getReservationId();
        this.restaurantName = dto.getRestaurantName();

        // LocalDateとintのhour, minuteからLocalDateTime型を生成
        this.reserveDatetime = LocalDateTime.of(dto.getReserveDate(), LocalTime.of(dto.getHour(), dto.getMinute()));
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus();
    }
}
