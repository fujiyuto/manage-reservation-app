package com.example.constants.enums.user;

public enum UserType {
    USER(1, "ユーザー"),
    RESTAURANT(2, "店舗");

    private final Integer value;
    private final String description;

    UserType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
