package com.example.TruyenHub.dto.req;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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
}
