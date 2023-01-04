package com.fastcampus.getinline.service;

import com.fastcampus.getinline.constants.EventStatus;
import com.fastcampus.getinline.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * event service
 *
 * @author david
 */
public interface EventService {
    /**
     * 검색어들을 받아서 이벤트 리스트들을 반환
     * @param placeId 장소ID
     * @param eventName 이벤트 이름
     * @param eventStatus 이벤트 상태
     * @param eventStartDatetime 시작 시간
     * @param eventEndDatetime 종료 시간
     * @return
     */
    List<EventDTO> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    );

    /**
     * 단건 이벤트 조회
     * @param eventId 이벤트 Id
     * @return
     */
    Optional<EventDTO> getEvent(Long eventId);

    /**
     * 이벤트 생성
     * @param eventDTO 이벤트 정보
     * @return
     */
    boolean createEvent(EventDTO eventDTO);

    /**
     * 이벤트 수정
     * @param eventId 이번트 ID
     * @param eventDTO 이번트 정보
     * @return
     */
    boolean modifyEvent(Long eventId, EventDTO eventDTO);

    /**
     * 이벤트 삭제
     * @param eventId 이벤트 Id
     * @return
     */
    boolean deleteEvent(Long eventId);
}
