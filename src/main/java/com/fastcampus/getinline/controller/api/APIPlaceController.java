package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.constants.PlaceType;
import com.fastcampus.getinline.dto.APIDataResponse;
import com.fastcampus.getinline.dto.PlaceRequest;
import com.fastcampus.getinline.dto.PlaceResponse;
import com.fastcampus.getinline.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/places")
public class APIPlaceController {

    private final PlaceService placeService;

    @GetMapping("/")
    public APIDataResponse<List<PlaceResponse>> getPlaces(
            Long placeId,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        List<PlaceResponse> response = PlaceResponse.from(placeService.getPlaces(placeId,PlaceType.COMMON,placeName,address,phoneNumber,createdAt,modifiedAt));
        return APIDataResponse.of(response);
    }

    @GetMapping("/{placeId}")
    public APIDataResponse<PlaceResponse> getPlace(@PathVariable Long placeId) {
        if(placeId.equals(2L)){
            return APIDataResponse.empty();
        }

        return APIDataResponse.of(PlaceResponse.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
                "신장개업"
        ));

    }

    @PostMapping("/")
    public APIDataResponse<Void> createPlaces() {
        return APIDataResponse.empty();
    }

    @PutMapping("/{placeId}")
    public APIDataResponse<Void> modifyPlaces(@PathVariable Long placeId) {
        return APIDataResponse.empty();
    }

    @DeleteMapping("/{placeId}")
    public APIDataResponse<Void> deletePlaces(@PathVariable Long placeId) {
        return APIDataResponse.empty();
    }
}
