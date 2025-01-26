package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.dto.query.ReservationQueryDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UpdateReservationResponse extends ApiResponse {
    private String userName;
    private String restaurantName;
    private LocalDateTime reserveDateTime;
    private int numberOfPeople;
    private Status status;
    private String notes;
    

    // レスポンスにメッセージを指定する場合
    public UpdateReservationResponse(ReservationQueryDto dto, String message)
    {
        // 親クラスのコンストラクタ
        super(message);

        this.userName = dto.getUserName();
        this.restaurantName = dto.getRestaurantName();
        this.reserveDateTime = LocalDateTime.of(dto.getReserveDate(), LocalTime.of(dto.getHour(), dto.getMinute()));
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus();
        this.notes = dto.getNotes();
    }

    public UpdateReservationResponse(ReservationQueryDto dto)
    {
        this.userName = dto.getUserName();
        this.restaurantName = dto.getRestaurantName();
        this.reserveDateTime = LocalDateTime.of(dto.getReserveDate(), LocalTime.of(dto.getHour(), dto.getMinute()));
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus();
        this.notes = dto.getNotes();
    }
}
