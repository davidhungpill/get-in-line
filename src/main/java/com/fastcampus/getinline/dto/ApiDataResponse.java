package com.fastcampus.getinline.dto;

import com.fastcampus.getinline.constants.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ApiDataResponse extends  ApiErrorResponse{

    private final Object data;

    private ApiDataResponse(boolean success, Integer errorCode, String message, Object data){
        super(success, errorCode, message);
        this.data = data;
    }

    public static ApiDataResponse of(boolean success, Integer errorCode, String message, Object data){
        return new ApiDataResponse(success, errorCode, message, data);
    }
}
