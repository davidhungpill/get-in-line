package com.fastcampus.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/places")
    public String adminPlaces(){return "admin/places";}

    @GetMapping("/places/{place-id}")
    public String adminPlaces(@PathVariable Integer placeId){return "admin/place-detail";}

    @GetMapping("/events")
    public String adminEvents(){return "admin/events";}

    @GetMapping("/events/{event-id}")
    public String adminEvents(@PathVariable Integer eventId){return "admin/event-detail";}
}
