package com.fastcampus.getinline.repository;

import com.fastcampus.getinline.constants.PlaceType;
import com.fastcampus.getinline.domain.Place;
import com.fastcampus.getinline.dto.PlaceDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    /**
     * 장소 목록 조회
     * @param placeId
     * @param placeType
     * @param placeName
     * @param address
     * @param phoneNumber
     * @param createdAt
     * @param modifiedAt
     * @return
     */
    default List<PlaceDTO> findPlaces(
            Long placeId,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {return List.of();}

    /**
     * 장소 단건 조회
     * @param placeId
     * @return
     */
    default Optional<PlaceDTO> findPlace(Long placeId){return Optional.empty();}

    /**
     * 장소 추가
     * @param placeDTO
     * @return
     */
    default boolean insertPlace(PlaceDTO placeDTO){return false;}

    /**
     * 장소 수정
     * @param placeId
     * @param placeDTO
     * @return
     */
    default boolean updatePlace(Long placeId, PlaceDTO placeDTO){return false;}

    /**
     * 장소 삭제
     * @param placeId
     * @return
     */
    default boolean deletePlace(Long placeId){return false;}
}
