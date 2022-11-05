package com.fastcampus.getinline.controller.error;

import com.fastcampus.getinline.constants.ErrorCode;
import com.fastcampus.getinline.dto.ApiErrorResponse;
import com.fastcampus.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(false, errorCode, errorCode.getMessage(e))
                );
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(false, errorCode, errorCode.getMessage(e))
                );
    }
}
