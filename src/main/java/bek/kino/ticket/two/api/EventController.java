package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/events")
@RestController
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/getAllEvents")
    public List<EventDTO> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PostMapping(value = "/addEvent")
    public EventDTO addEvent(@RequestBody EventDTO eventDTO){
        return eventService.addEvent(eventDTO);
    }
    @PostMapping(value = "/getEvent/{id}")
    public EventDTO getEventById(@PathVariable(name = "id") Long id){
        return eventService.getEventById(id);
    }
    @PostMapping(value = "/updateEvent")
    public EventDTO updateEvent(@RequestBody Long id){
        return eventService.updateEvent(id);
    }
}
