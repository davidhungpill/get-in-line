package com.fastcampus.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class APIEventController {

    @GetMapping("/")
    public String getEvents(){
        return List.of("event1","event2").toString();
    }

    @GetMapping("/{event-id}")
    public String getEvent(@PathVariable Integer eventId){
        return "event "+ eventId;
    }

    @PostMapping("/")
    public Boolean createEvents(){
        return true;
    }

    @PutMapping("/{event-id}")
    public Boolean modifyEvents(@PathVariable Integer eventId){
        return true;
    }

    @DeleteMapping("/{event-id}")
    public Boolean deleteEvents(@PathVariable Integer eventId){
        return true;
    }
}
