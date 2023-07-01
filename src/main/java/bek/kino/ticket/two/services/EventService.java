package bek.kino.ticket.two.services;


import bek.kino.ticket.two.BodySample.EventSample;
import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.impl.EventRepoImpl;
import bek.kino.ticket.two.impl.HallRepoImpl;
import bek.kino.ticket.two.mapper.EventMapper;
import bek.kino.ticket.two.model.Event;
import bek.kino.ticket.two.model.Hall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepoImpl eventRepo;

	private final HallRepoImpl hallRepo;
	private final EventMapper eventMapper;

	public List<EventDTO> getAllEvents() {
		return eventMapper.toDtoList(eventRepo.getAllEvents());
	}

	public EventDTO addEvent(EventDTO eventDTO) {
		return eventMapper.toDto(eventRepo.addEvent(eventMapper.toModel(eventDTO)));
	}

	public EventDTO getEventById(Long id) {
		return eventMapper.toDto(eventRepo.getEventById(id));
	}

	public EventDTO updateEvent(EventSample eventSample) {
		Event event = new Event();
		event.setId(eventSample.getId());
		event.setAuthor(eventSample.getAuthor());
		event.setEvent_date(eventSample.getEvent_date());
		event.setEventName(eventSample.getEventName());
		event.setPrice(eventSample.getPrice());
		Hall hall = hallRepo.getHallById(eventSample.getHall_id());
		event.setHall(hall);
		event.setPictureLink(eventSample.getPictureLink());
		return eventMapper.toDto(eventRepo.updateEvent(event));
	}
}
