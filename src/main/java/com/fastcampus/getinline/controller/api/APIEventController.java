package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.constants.ErrorCode;
import com.fastcampus.getinline.constants.EventStatus;
import com.fastcampus.getinline.dto.APIDataResponse;
import com.fastcampus.getinline.dto.APiErrorResponse;
import com.fastcampus.getinline.dto.EventResponse;
import com.fastcampus.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class APIEventController {

    @GetMapping("/")
    public APIDataResponse<List<EventResponse>> getEvents() {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                0,
                24,
                "마스크 꼭 착용하세요"
        )));
    }

    @GetMapping("/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Long eventId) {
        if (eventId.equals(2L)) {
            return APIDataResponse.empty();
        }

        return APIDataResponse.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                0,
                24,
                "마스크 꼭 착용하세요"
        ));
    }

    @PostMapping("/")
    public APIDataResponse<Void> createEvents() {
        return APIDataResponse.empty();
    }

    @PutMapping("/{eventId}")
    public APIDataResponse<Void> modifyEvents(@PathVariable Long eventId) {
        return APIDataResponse.empty();
    }

    @DeleteMapping("/{eventId}")
    public APIDataResponse<EventResponse> deleteEvents(@PathVariable Long eventId) {
        return APIDataResponse.empty();
    }

    @ExceptionHandler
    public ResponseEntity<APiErrorResponse> general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(APiErrorResponse.of(false, errorCode, errorCode.getMessage(e))
                );
    }
}
