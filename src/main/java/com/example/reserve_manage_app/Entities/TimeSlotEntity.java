package com.example.reserve_manage_app.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "time_slots")
public class TimeSlotEntity {
    /**
     * 時間帯ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 時間
     */
    @Column(name = "hour")
    private int hour;

    /**
     * 分
     */
    @Column(name = "minute")
    private int minute;
}
