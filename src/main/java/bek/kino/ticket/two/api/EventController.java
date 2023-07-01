package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.EventSample;
import bek.kino.ticket.two.BodySample.EventStatus;
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
	public List<EventDTO> getAllEvents() {
		return eventService.getAllEvents();
	}

	@PostMapping(value = "/addEvent")
	public EventDTO addEvent(@RequestBody EventSample eventSample) {
		return eventService.addEvent(eventSample);
	}

	@GetMapping(value = "/getEvent/{id}")
	public EventDTO getEventById(@PathVariable(name = "id") Long id) {
		return eventService.getEventById(id);
	}

	@PostMapping(value = "/updateEvent")
	public EventDTO updateEvent(@RequestBody EventSample eventSample) {
		return eventService.updateEvent(eventSample);
	}

	@GetMapping(value = "/getAllActivityEvents")
	public List<EventDTO> getAllActivityEvents(){
		return eventService.getAllActivityEvents();
	}

	@PostMapping(value = "/event-status-change")
	public EventDTO changeStatus(@RequestBody EventStatus eventStatus){
		return eventService.changeStatus(eventStatus);
	}
}
