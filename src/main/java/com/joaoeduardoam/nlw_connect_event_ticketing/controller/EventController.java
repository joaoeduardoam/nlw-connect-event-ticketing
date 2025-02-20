package com.joaoeduardoam.nlw_connect_event_ticketing.controller;

import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.EventInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.business.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EventController {


    private final EventService service;

    @PostMapping("/events")
    public ResponseEntity<EventOutDTO> addNewEvent(@RequestBody @Valid EventInDTO eventInDTO){
        return ResponseEntity.ok(service.addNewEvent(eventInDTO));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventOutDTO>> getAllEvents(){
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/events/{prettyName}")
    public ResponseEntity<EventOutDTO> getEventByPrettyName(@PathVariable String prettyName){
        return ResponseEntity.ok(service.getByPrettyName(prettyName));
    }
}
