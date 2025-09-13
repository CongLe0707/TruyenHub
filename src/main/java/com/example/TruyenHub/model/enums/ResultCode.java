package com.example.TruyenHub.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResultCode implements IResultCode{
    ;
    private String code;
    private  String message;

    ResultCode(String code, String message ) {
        this.code = code;
        this.message = message;

    }
}
