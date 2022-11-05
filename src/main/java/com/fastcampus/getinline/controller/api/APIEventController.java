package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.constants.ErrorCode;
import com.fastcampus.getinline.dto.ApiErrorResponse;
import com.fastcampus.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class APIEventController {

    @GetMapping("/")
    public String getEvents(){
        throw new RuntimeException("runtime exception");
        //return List.of("event1","event2").toString();
    }

    @GetMapping("/{event-id}")
    public String getEvent(@PathVariable Integer eventId){
        return "event "+ eventId;
    }

    @PostMapping("/")
    public Boolean createEvents(){
        return true;
    }

    @PutMapping("/{event-id}")
    public Boolean modifyEvents(@PathVariable Integer eventId){
        return true;
    }

    @DeleteMapping("/{event-id}")
    public Boolean deleteEvents(@PathVariable Integer eventId){
        return true;
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> general(GeneralException e){
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(false, errorCode, errorCode.getMessage(e))
                );
    }
}
