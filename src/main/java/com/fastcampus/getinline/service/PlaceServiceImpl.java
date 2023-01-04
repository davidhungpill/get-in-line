package com.fastcampus.getinline.service;

import com.fastcampus.getinline.constants.PlaceType;
import com.fastcampus.getinline.dto.PlaceDTO;
import com.fastcampus.getinline.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements  PlaceService{

    private final PlaceRepository placeRepository;

    @Override
    public List<PlaceDTO> getPlaces(Long placeId, PlaceType placeType, String placeName, String address, String phoneNumber, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        return placeRepository.findPlaces(placeId, placeType, placeName, address, phoneNumber, createdAt, modifiedAt);
    }

    @Override
    public Optional<PlaceDTO> getPlace(Long placeId) {
        return placeRepository.findPlace(placeId);
    }

    @Override
    public boolean insertPlace(PlaceDTO placeDTO) {
        return placeRepository.insertPlace(placeDTO);
    }

    @Override
    public boolean updatePlace(Long placeId, PlaceDTO placeDTO) {
        return placeRepository.updatePlace(placeId, placeDTO);
    }

    @Override
    public boolean deletePlace(Long placeId) {
        return placeRepository.deletePlace(placeId);
    }
}
