package com.example.reserve_manage_app.Validations.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.reserve_manage_app.Validations.Validators.ReservationStatusValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReservationStatusValidator.class)
public @interface ValidReservationStatus {
    String message() default "無効なステータスです。";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
