package com.fastcampus.getinline.controller;

import com.fastcampus.getinline.constants.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/places")
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeType);
        map.put("placeName", placeName);
        map.put("address", address);

        return new ModelAndView("places/places", map);
    }

    @GetMapping("/places/{place-id}")
    public String adminPlaces(@PathVariable Integer placeId){return "admin/place-detail";}

    @GetMapping("/events")
    public String adminEvents(){return "admin/events";}

    @GetMapping("/events/{event-id}")
    public String adminEvents(@PathVariable Integer eventId){return "admin/event-detail";}
}
