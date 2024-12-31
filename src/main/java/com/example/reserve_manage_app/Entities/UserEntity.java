package com.example.reserve_manage_app.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.Constants.Enums.User.Gender;
import com.example.Constants.Enums.User.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    /**
     * ユーザーID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ユーザー名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * メールアドレス
     */
    @Column(name = "email")
    private String email;

    /**
     * 電話番号
     */
    @Column(name = "tel_no", length = 13)
    private String phoneNumber;

    /**
     * 誕生日
     */
    @Column(name = "誕生日")
    private LocalDate birthday;

    /**
     * メール認証日時
     */
    @Column(name = "メール認証日時", nullable = true)
    private LocalDateTime emailVerifiedAt;

    /**
     * パスワード
     */
    @Column(name = "password")
    private String password;

    /**
     * 性別
     */
    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    /**
     * ユーザータイプ
     */
    @Column(name = "user_type")
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    /**
     * 投稿数
     */
    @Column(name = "post_num")
    private int numberOfPost;

    /**
     * フォロワー数
     */
    @Column(name = "follower_num")
    private int numberOfFollower;

    /**
     * フォロー数
     */
    @Column(name = "follow_num")
    private int numberOfFollow;

    /**
     * 訪問数
     */
    @Column(name = "visited_num")
    private int numberOfVisit;

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
