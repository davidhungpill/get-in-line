package com.fastcampus.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class APIPlaceController {

    @GetMapping("/")
    public String getPlaces(){
        return List.of("place1","place2").toString();
    }

    @GetMapping("/{place-id}")
    public String getPlace(@PathVariable Integer placeId){
        return "place "+ placeId;
    }

    @PostMapping("/")
    public Boolean createPlaces(){
        return true;
    }

    @PutMapping("/{place-id}")
    public Boolean modifyPlaces(@PathVariable Integer placeId){
        return true;
    }

    @DeleteMapping("/{place-id}")
    public Boolean deletePlaces(@PathVariable Integer placeId){
        return true;
    }
}
