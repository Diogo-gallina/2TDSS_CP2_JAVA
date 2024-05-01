package br.com.fiap.eventmanager.controller;

import br.com.fiap.eventmanager.dto.event.CreateEventDTO;
import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<EventDetailsDTO> create(@RequestBody CreateEventDTO eventDTO,
                                                  UriComponentsBuilder uri){
        Event event = new Event(eventDTO);
        var newEvent = eventService.create(event);
        var url = uri.path("/events/{event_id}").buildAndExpand(event.getId()).toUri();

        return ResponseEntity.created(url).body(newEvent);
    }

}
