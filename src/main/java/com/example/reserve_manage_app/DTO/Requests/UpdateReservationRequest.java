package com.example.reserve_manage_app.DTO.Requests;

import java.time.LocalDateTime;

import com.example.Constants.Enums.Reservation.Status;
import com.example.reserve_manage_app.Validations.Annotations.ValidReservationStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateReservationRequest {
    /**
     * 予約日時
     */
    @Future(message = "予約日時が正しくありません。")
    private LocalDateTime reserveDatetime;

    /**
     * 予約人数
     */
    @Min(value = 1, message = "予約人数は1名以上からです。")
    @Max(value = 8, message = "予約人数は8名までです。")
    private int numberOfPeople;

    /**
     * 予約状況
     */
    @ValidReservationStatus
    private Status status;

    /**
     * 特記事項
     */
    @Size(max = 500, message = "特記事項は500文字以内で入力してください。")
    private String notes;
}
