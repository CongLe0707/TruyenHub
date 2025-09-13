package com.example.TruyenHub.exception;

public class BaseException extends RuntimeException  {

    private String errCode;
    private String errMessage;

    BaseException(String errCode, String errMessage) {
        super("%s".formatted(errMessage));
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

}
