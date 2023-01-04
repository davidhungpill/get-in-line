package com.fastcampus.getinline.repository;


import com.fastcampus.getinline.constants.EventStatus;
import com.fastcampus.getinline.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// TODO:  인스턴스 생성 편의를 위해 임시로  default 사용, repository Layer 구현이 완성되면 삭제할 것
public interface EventRepository {

    /**
     * 이벤트 리스트 조회
     * @param placeId
     * @param eventName
     * @param eventStatus
     * @param eventStartDatetime
     * @param eventEndDatetime
     * @return
     */
    default List<EventDTO> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ){return List.of();}

    /**
     * 이벤트 항목 조회
     * @param eventId
     * @return
     */
    default Optional<EventDTO> findEvent(Long eventId) {return Optional.empty();}

    /**
     * 이벤트 생성
     * @param eventDTO
     * @return
     */
    default boolean insertEvent(EventDTO eventDTO){return false;}

    /**
     * 이벤트 수정
     * @param eventDTO
     * @return
     */
    default boolean updateEvent(Long id, EventDTO eventDTO){return false;}

    /**
     * 이벤트 삭제
     * @param eventId
     * @return
     */
    default boolean deleteEvent(Long eventId){return false;}
}
