package com.example.TruyenHub.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResultCode implements IResultCode{
    SUCCESS("0000","Thành công"),
    ID_NOT_FOUND("404","Số id đã bị trùng")
    ;
    private String code;
    private  String message;

    ResultCode(String code, String message ) {
        this.code = code;
        this.message = message;

    }
}
