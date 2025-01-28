package com.example.reserve_manage_app.validations.validators;

import java.util.Arrays;

import com.example.constants.enums.reservation.Status;
import com.example.reserve_manage_app.validations.annotations.ValidReservationStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ReservationStatusValidator implements ConstraintValidator<ValidReservationStatus, Status> {
    @Override
    public boolean isValid(Status value, ConstraintValidatorContext context) {
        // デフォルトメッセージを無効化
        context.disableDefaultConstraintViolation();
        if ( value == null ) {
            // より具体的なエラーメッセージを設定
            context.buildConstraintViolationWithTemplate(
            "予約状況は必須です。"
            ).addConstraintViolation();

            return false;
        }

        boolean valid = Arrays.asList(Status.values()).contains(value);

        if ( !valid ) {
            context.buildConstraintViolationWithTemplate(
            "予約状況の値が間違っています。"
            ).addConstraintViolation();
        }

        return valid;
    }
}
