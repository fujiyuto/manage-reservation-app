package com.example.constants.enums.reservation;


public enum Status {
    PENDING("保留中"),
    CONFIRMED("予約確定"),
    CANCELLED("キャンセル済み"),
    COMPLETED("来店済み");

    private final String description;

    Status (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
