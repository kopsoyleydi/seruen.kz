package bek.kino.ticket.two.services;


import bek.kino.ticket.two.BodySample.EventSample;
import bek.kino.ticket.two.BodySample.EventStatus;
import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.impl.EventRepoImpl;
import bek.kino.ticket.two.impl.HallRepoImpl;
import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.mapper.EventMapper;
import bek.kino.ticket.two.mapper.TicketMapper;
import bek.kino.ticket.two.model.Event;
import bek.kino.ticket.two.model.Hall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepoImpl eventRepo;

	private final HallRepoImpl hallRepo;
	private final EventMapper eventMapper;

	private final TicketsRepoImpl ticketsRepo;

	private final TicketMapper ticketMapper;
	private final ListsForData lists;

	public List<EventDTO> getAllEvents() {
		return eventMapper.toDtoList(eventRepo.getAllEvents());
	}

	public EventDTO addEvent(EventSample eventSample) {
		Event event = new Event();
		event.setId(eventSample.getId());
		event.setAuthor(eventSample.getAuthor());
		event.setEvent_date(eventSample.getEvent_date());
		event.setEventName(eventSample.getEventName());
		event.setPrice(eventSample.getPrice());
		Hall hall = hallRepo.getHallById(eventSample.getHall_id());
		event.setHall(hall);
		event.setPictureLink(eventSample.getPictureLink());
		event.setStatus("true");
		return eventMapper.toDto(eventRepo.addEvent(event));
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
		event.setStatus("true");
		Hall hall = hallRepo.getHallById(eventSample.getHall_id());
		event.setHall(hall);
		event.setPictureLink(eventSample.getPictureLink());
		return eventMapper.toDto(eventRepo.updateEvent(event));
	}

	public List<EventDTO> getAllActivityEvents() {
		return eventMapper.toDtoList(eventRepo.getAllActivityEvents());
	}

	public EventDTO changeStatus(EventStatus eventStatus) {
		Event event = eventRepo.getEventById(eventStatus.getId());
		event.setStatus(eventStatus.getStatus());
		return eventMapper.toDto(eventRepo.updateEvent(event));
	}


	public List<Integer> listPlaces(Long id) {
		List<Integer> places = new ArrayList<>();
		List<Integer> listPlace = lists.getPlaces();
		List<TicketDTO> ticketsList = ticketMapper.toDtoList(ticketsRepo.getTicketByEventId(id));
		for (TicketDTO ticketDTO : ticketsList) {
			places.add(ticketDTO.getPlace());
		}
		listPlace.removeAll(places);
		return listPlace;
	}
}
