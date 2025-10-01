package com.example.TruyenHub.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResultCode implements IResultCode{
    SUCCESS("0000","Thành công"),
    ID_NOT_FOUND("404","Số id không tồn tại"),
    INVALID_JSON_FORMAT("123", "Dữ liệu json không đúng định dạng"),
    VALIDATION_ERROR("1234", "Lỗi"),
    INTERNAL_SERVER_ERROR("234", "Lỗi server"),

    NO_AUTHOR("411","Không tim thấy tác giả"),
    NO_CATEGORY("412","không tìm thấy tên tác giả" ),
    NO_STORY_NAME("413","Không tìm thấy truyện" ),
    NO_COMIC_NAME("414","Không tìm thấy truyện tranh" );


    private String code;
    private  String message;

    ResultCode(String code, String message ) {
        this.code = code;
        this.message = message;

    }
}
