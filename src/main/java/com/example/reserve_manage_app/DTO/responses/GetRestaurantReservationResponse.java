package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.dto.query.RestaurantReservationListQueryDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GetRestaurantReservationResponse extends ApiResponse {

    private List<RestaurantReservationResponse> data;

    public GetRestaurantReservationResponse(List<RestaurantReservationListQueryDto> reservationList, String message) {
        // 親クラスのコンストラクタ
        super(message);

        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<RestaurantReservationResponse> response = new ArrayList<>();
        for (RestaurantReservationListQueryDto reservation : reservationList) {
            RestaurantReservationResponse res = new RestaurantReservationResponse(reservation);
            response.add(res);
        }
        this.data = response;
    }

    public GetRestaurantReservationResponse(List<RestaurantReservationListQueryDto> reservationList) {
        // 取得した予約データのリストをレスポンス用のオブジェクトに変換し、
        // dataに格納
        List<RestaurantReservationResponse> response = new ArrayList<>();
        for (RestaurantReservationListQueryDto reservation : reservationList) {
            RestaurantReservationResponse res = new RestaurantReservationResponse(reservation);
            response.add(res);
        }
        this.data = response;
    }
}

class RestaurantReservationResponse {
    private Long reservationId;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reserveDatetime;

    private int numberOfPeople;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Status status;

    RestaurantReservationResponse (RestaurantReservationListQueryDto dto) {
        this.reservationId = dto.getReservationId();
        this.userName = dto.getUserName();

        // LocalDateとintのhour, minuteからLocalDateTime型を生成
        this.reserveDatetime = LocalDateTime.of(dto.getReserveDate(), LocalTime.of(dto.getHour(), dto.getMinute()));
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus();
    }
}
