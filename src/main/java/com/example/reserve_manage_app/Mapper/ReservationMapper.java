package com.example.reserve_manage_app.Mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.Entities.ReservationEntity;

@Mapper
public interface ReservationMapper {
    /**
     * 店IDを使用し、予約データを取得する
     * @param  Long restaurantId 店ID
     * @return List<ReservationEntity> 予約データの一覧
     */
    @Select("SELECT * FROM reservations WHERE restaurant_id = #{restaurantId}")
    List<ReservationEntity> getRestaurantReservationData(@Param("restaurantId") Long restaurantId);

    /**
     * ユーザーIDを使用し、予約データを取得する
     * @param  Long reservationId 店ID
     * @return List<ReservationEntity> 予約データの一覧
     */
    @Select("SELECT * FROM reservations WHERE user_id = #{userId}")
    List<ReservationEntity> getUserReservationData(@Param("userId") Long userId);

    /**
     * 予約データIDを使用し、予約データを取得する
     */
    @Select("SELECT * FROM reservations WHERE reservation_id = #{reservationId}")
    ReservationEntity getReservationData(@Param("reservationId") Long reservationId);

    /**
     * 予約データを作成する
     * @param userId
     * @param restaurantId
     * @param reserveDateTime
     * @param numberOfPeople
     * @param status
     * @param notes
     */
    @Insert("INSERT INTO reservations(user_id, restaurant_id, reserve_date_time, num_of_people, status, notes) VALUES(#{userId}, #{restaurantId}, #{reserveDateTime}, #{numberOfPeople}, #{status}, #{notes})")
    int createReservation(
        @Param("user_id") Long userId,
        @Param("restaurant_id") Long restaurantId,
        @Param("reserve_date_time") LocalDateTime reserveDateTime,
        @Param("num_of_people") int numberOfPeople,
        @Param("notes") String notes
    );

    /**
     * 予約データを更新する
     * @param reservationId
     * @param reserveDateTime
     * @param numberOfPeople
     * @param notes
     */
    @Update("UPDATE reservations SET reserve_date_time = #{reserveDateTime}, num_of_people = #{numberOfPeople}, notes = #{notes} WHERE reservation_id = #{reservationId}")
    int updateReservation(
        Long reservationId, 
        @Param("reserve_date_time") LocalDateTime reserveDateTime,
        @Param("num_of_people") int numberOfPeople,
        @Param("notes") String notes 
    );

    /**
     * 予約データのステータスを更新する
     * @param status
     */
    @Update("UPDATE reservations SET status = #{status} WHERE reservation_id = #{reservationId}")
    int updateReservationStatus(
        @Param("reservation_id") Long reservationId, 
        @Param("status") Status status
    );
}
