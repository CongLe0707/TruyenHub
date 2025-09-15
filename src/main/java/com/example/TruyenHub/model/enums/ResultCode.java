package com.example.TruyenHub.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResultCode implements IResultCode{
    SUCCESS("0000","Thành công"),
    ID_NOT_FOUND("404","Số id không tồn tại"),
    INVALID_JSON_FORMAT("123", "Dữ liệu json không đúng định dạng"),
    VALIDATION_ERROR("1234", "Lỗi"),
    INTERNAL_SERVER_ERROR("234", "Lỗi server")
    ;
    private String code;
    private  String message;

    ResultCode(String code, String message ) {
        this.code = code;
        this.message = message;

    }
}
