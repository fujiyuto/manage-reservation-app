package com.example.reserve_manage_app.mapper;

import java.util.Date;
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
    @Select("SELECT * FROM reservations WHERE restaurant_id = #{restaurant_id}")
    List<ReservationEntity> getRestaurantReservationData(@Param("restaurant_id") Long restaurantId);

    /**
     * ユーザーIDを使用し、予約データを取得する
     * @param  Long reservationId 店ID
     * @return List<ReservationEntity> 予約データの一覧
     */
    @Select("SELECT * FROM reservations WHERE user_id = #{user_id}")
    List<ReservationEntity> getUserReservationData(@Param("user_id") Long userId);

    /**
     * 予約データIDを使用し、予約データを取得する
     */
    @Select("SELECT * FROM reservations WHERE id = #{reservation_id}")
    ReservationEntity getReservationData(@Param("reservation_id") Long reservationId);

    /**
     * 予約データを作成する
     * @param userId
     * @param restaurantId
     * @param reserveDateTime
     * @param numberOfPeople
     * @param status
     * @param notes
     * @param timeSlotId
     */
    @Insert("INSERT INTO reservations(user_id, restaurant_id, reserve_date, num_of_people, notes, time_slot_id) VALUES(#{user_id}, #{restaurant_id}, #{reserve_date}, #{num_of_people}, #{notes} #{time_slot_id})")
    int createReservation(
        @Param("user_id")       Long userId,
        @Param("restaurant_id") Long restaurantId,
        @Param("reserve_date")  Date reserveDate,
        @Param("num_of_people") int numberOfPeople,
        @Param("notes")         String notes,
        @Param("time_slot_id")  Long timeSlotId
    );

    /**
     * 予約データを更新する
     * @param reservationId
     * @param reserveDateTime
     * @param numberOfPeople
     * @param notes
     * @param timeSlotId
     */
    @Update("UPDATE reservations SET reserve_date_time = #{reserve_date_time}, num_of_people = #{num_of_people}, notes = #{notes} WHERE id = #{reservation_id}")
    int updateReservation(
        @Param("reservation_id")    Long reservationId, 
        @Param("reserve_date_time") Date reserveDateTime,
        @Param("num_of_people")     int numberOfPeople,
        @Param("notes")             String notes,
        @Param("time_slot_id")      Long timeSlotId
    );

    /**
     * 予約データのステータスを更新する
     * @param status
     */
    @Update("UPDATE reservations SET status = #{status} WHERE id = #{reservation_id}")
    int updateReservationStatus(
        @Param("reservation_id") Long reservationId, 
        @Param("status") Status status
    );
}
