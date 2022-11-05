package com.fastcampus.getinline.dto;


import com.fastcampus.getinline.constants.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class APiErrorResponse {

    private final Boolean success;
    private final Integer errorCode;
    private final String message;

    public static APiErrorResponse of(Boolean success, Integer errorCode, String message) {
        return new APiErrorResponse(success, errorCode, message);
    }

    public static APiErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new APiErrorResponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static APiErrorResponse of(Boolean success, ErrorCode errorCode, Exception e) {
        return new APiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static APiErrorResponse of(Boolean success, ErrorCode errorCode, String message) {
        return new APiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}
