package com.example.reserve_manage_app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.reserve_manage_app.dto.query.ReservationQueryDto;
import com.example.reserve_manage_app.dto.query.RestaurantReservationListQueryDto;
import com.example.reserve_manage_app.dto.query.UserReservationListQueryDto;
import com.example.reserve_manage_app.dto.requests.CreateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationStatusRequest;

@Mapper
public interface ReservationMapper {
    /**
     * 店IDを使用し、予約データを取得する
     * @param  Long restaurantId 店ID
     * @return List<RestaurantReservationListQueryDto> 予約データの一覧
     */
    List<RestaurantReservationListQueryDto> getRestaurantReservationData(Long restaurantId);

    /**
     * ユーザーIDを使用し、予約データを取得する
     * @param  Long reservationId 店ID
     * @return List<UserReservationListQueryDto> 予約データの一覧
     */
    List<UserReservationListQueryDto> getUserReservationData(Long userId);

    /**
     * 予約データIDを使用し、予約データを取得する
     * @param Long reservationId
     * @return 
     */
    ReservationQueryDto getReservationData(Long reservationId);

    /**
     * 予約データを作成する
     * @param  CreateReservationRequest request
     * @return int
     */
    boolean createReservation(CreateReservationRequest request);

    /**
     * 予約データを更新する
     * @param  UpdateReservationRequest request
     * @return int
     */
    boolean updateReservation(@Param("reservationId") Long reservationId, @Param("request") UpdateReservationRequest request);

    /**
     * 予約データのステータスを更新する
     * @param  UpdateReservationStatusRequest request
     * @return int
     */
    boolean updateReservationStatus(@Param("reservationId") Long reservationId, @Param("request") UpdateReservationStatusRequest request);
}
