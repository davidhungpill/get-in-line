package com.fastcampus.getinline.controller.api;

import com.fastcampus.getinline.constants.PlaceType;
import com.fastcampus.getinline.dto.APIDataResponse;
import com.fastcampus.getinline.dto.PlaceRequest;
import com.fastcampus.getinline.dto.PlaceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class APIPlaceController {

    @GetMapping("/")
    public APIDataResponse<List<PlaceResponse>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceResponse.of(
                PlaceType.COMMON,
                "랄라베드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
                "신장개업"
        )));
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
