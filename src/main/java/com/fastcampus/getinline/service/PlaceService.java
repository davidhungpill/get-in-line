package com.fastcampus.getinline.service;

import com.fastcampus.getinline.constants.PlaceType;
import com.fastcampus.getinline.dto.PlaceDTO;
import com.fastcampus.getinline.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * place service
 *
 * @author : david
 */

public interface PlaceService {

    /**
     * 장소 조회
     * @param placeId
     * @param placeType
     * @param placeName
     * @param address
     * @param phoneNumber
     * @param createdAt
     * @param modifiedAt
     * @return
     */
    public List<PlaceDTO> getPlaces(
            Long placeId,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    );

    /**
     * 장소 단건 조회
     * @param placeId
     * @return
     */
    public Optional<PlaceDTO> getPlace(Long placeId);

    /**
     * 장소 추가
     * @param placeDTO
     * @return
     */
    public boolean insertPlace(PlaceDTO placeDTO);

    /**
     * 장소 수정
     * @param placeDTO
     * @param placeId
     * @return
     */
    public boolean updatePlace(Long placeId, PlaceDTO placeDTO);

    /**
     * 장소 삭제
     * @param placeId
     * @return
     */
    public boolean deletePlace(Long placeId);

}
