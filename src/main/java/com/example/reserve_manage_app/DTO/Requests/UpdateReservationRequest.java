package com.example.reserve_manage_app.dto.requests;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateReservationRequest {
    /**
     * 予約日
     */
    @NotNull(message = "予約日を指定してください。")
    @Future(message = "予約日が正しくありません。")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reserveDate;

    /**
     * 時間帯
     */
    @NotNull(message = "時間が指定されていません。")
    private Long reserveTime;

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

    /**
     * 更新者ID
     */
    @NotNull(message = "更新者がありません。")
    private Long updatedBy;
}
