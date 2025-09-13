package com.example.TruyenHub.anotation;

import jakarta.validation.Payload;



public @interface PhoneNumber {
    String message() default "Số điện thoại chỉ được chứa ký tự số";
    boolean required() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}