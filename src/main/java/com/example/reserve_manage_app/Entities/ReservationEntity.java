package com.example.reserve_manage_app.Entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.example.constants.enums.reservation.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@Table(name = "reservations")
public class ReservationEntity {
    /**
     * 予約ID 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * ユーザー（ユーザーID）
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    /**
     * 店（店ID）
     */
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    /**
     * 予約日時
     */
    @Column(name = "reserve_date_time")
    private LocalDateTime reserveDatetime;

    /**
     * 予約人数
     */
    @Column(name = "num_of_people")
    private int numberOfPeople;

    /**
     * 予約状況
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    
    /**
     * 特記事項
     */
    @Column(name = "notes")
    private String notes;

    /**
     * 作成日時
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
