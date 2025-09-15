package com.example.TruyenHub.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException  {

    private String errCode;
    private String errMessage;

    public BaseException(String errCode, String errMessage) {
        super("%s".formatted(errMessage));
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

}
