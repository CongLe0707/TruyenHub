package com.example.TruyenHub.dto.req;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class CommonReq <T> {

    private  String requestId;
    private  String requestTime;

    private  T data;

    @JsonCreator
    public CommonReq(
            @JsonProperty("requestId") String requestId,
            @JsonProperty("requestTime") String requestTime
    ) {
        this.requestId = requestId;
        this.requestTime = requestTime;

    }

    public CommonReq(T data) {
        this.data = data;
    }
}
