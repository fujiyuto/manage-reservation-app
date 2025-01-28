package com.example.reserve_manage_app.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "restaurants")
public class RestaurantEntity {
    /**
     * 店ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店名
     */
    @Column(name = "restaurant_name")
    private String restaurantName;

    /**
     * 郵便番号
     */
    @Column(name = "zip_cd", length = 7)
    private String zipCode;

    /**
     * 住所
     */
    @Column(name = "address")
    private String address;

    /**
     * 住所詳細
     */
    @Column(name = "address_detail", nullable = true)
    private String addressDetail;

    /**
     * メールアドレス
     */
    @Column(name = "email", nullable = true)
    private String email;

    /**
     * 電話番号
     */
    @Column(name = "tel_no")
    private String phoneNumber;

    /**
     * 価格（最小）
     */
    @Column(name = "price_min", nullable = true)
    private int priceMin;

    /**
     * 価格（最大）
     */
    @Column(name = "price_max", nullable = true)
    private int priceMax;

    /**
     * 投稿数
     */
    @Column(name = "post_num")
    private int postNum;

    /**
     * 平均点数
     */
    @Column(name = "point_avg")
    private Double pointAvg;

    /**
     * 作成日時
     */
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    private LocalDateTime updatedAt;
}
