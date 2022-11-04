package com.fastcampus.getinline.domain;

import com.fastcampus.getinline.constants.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {

    private Long id;
    private Place place;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;

}
