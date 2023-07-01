package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Event;
import bek.kino.ticket.two.repo_services.EventRepoInterface;
import bek.kino.ticket.two.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventRepoImpl implements EventRepoInterface {

	private final EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepository.findAllById(id);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getAllActivityEvents() {
		return eventRepository.findAllActivity();
	}
}
