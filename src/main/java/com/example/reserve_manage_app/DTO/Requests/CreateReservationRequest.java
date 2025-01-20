package com.example.reserve_manage_app.dto.requests;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateReservationRequest {
    /**
     * ユーザーID
     */
    @NotNull(message = "ユーザーIDが正しくありません。")
    private Long userId;

    /**
     * 店ID
     */
    @NotNull(message = "店IDが正しくありません。")
    private Long restaurantId;

    /**
     * 予約日時
     */
    @NotNull(message = "予約日を指定してください。")
    @Future(message = "予約日が正しくありません。")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
