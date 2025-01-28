package com.example.reserve_manage_app.dto.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.dto.query.ReservationQueryDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UpdateReservationResponse extends ApiResponse {
    /**
     * ユーザー名
     */
    private String userName;

    /**
     * 店名
     */
    private String restaurantName;

    /**
     * 予約日
     */
    private String reserveDate;

    /**
     * 予約時間
     */
    private String reserveTime;

    /**
     * 予約人数
     */
    private int numberOfPeople;

    /**
     * 予約状況
     */
    private String status;

    /**
     * 特記事項
     */
    private String notes;
    

    // レスポンスにメッセージを指定する場合
    public UpdateReservationResponse(ReservationQueryDto dto, String message)
    {
        // 親クラスのコンストラクタ
        super(message);

        this.userName = dto.getUserName();
        this.restaurantName = dto.getRestaurantName();
        this.reserveDate = dto.getReserveDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.reserveTime = leftPadString(dto.getHour()) + ":" + leftPadString(dto.getMinute());
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus().getDescription();
        this.notes = dto.getNotes();
    }

    public UpdateReservationResponse(ReservationQueryDto dto)
    {
        this.userName = dto.getUserName();
        this.restaurantName = dto.getRestaurantName();
        this.reserveDate = dto.getReserveDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.reserveTime = leftPadString(dto.getHour()) + ":" + leftPadString(dto.getMinute());
        this.numberOfPeople = dto.getNumberOfPeople();
        this.status = dto.getStatus().getDescription();
        this.notes = dto.getNotes();
    }

    /**
     * 数値を渡して1桁であれば0左埋めした文字列を返す
     * @param num 
     * @return
     */
    private String leftPadString(int num) {
        if ( num > 9 ) {
            return String.valueOf(num);
        } else {
            return "0" + String.valueOf(num);
        }
    }
}
