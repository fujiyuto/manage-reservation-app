package com.example.constants.enums.user;

public enum Gender {
    MALE(1, "男性"),
    FEMALE(2, "女性");

    private final Integer value;
    private final String description;

    Gender(Integer value, String description) {
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
