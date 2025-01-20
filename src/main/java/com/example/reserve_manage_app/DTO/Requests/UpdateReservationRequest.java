package com.example.reserve_manage_app.dto.requests;

import java.util.Date;

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
    @Future(message = "予約日が正しくありません。")
    private Date reserveDate;

    /**
     * 予約人数
     */
    @Min(value = 1, message = "予約人数は1名以上からです。")
    @Max(value = 8, message = "予約人数は8名までです。")
    private int numberOfPeople;

    /**
     * 特記事項
     */
    @Size(max = 500, message = "特記事項は500文字以内で入力してください。")
    private String notes;
}
