package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.impl.EventRepoImpl;
import bek.kino.ticket.two.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepoImpl eventRepo;

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

	public EventDTO updateEvent(Long id) {
		EventDTO eventDTO = eventMapper.toDto(eventRepo.getEventById(id));
		return eventMapper.toDto(eventRepo.updateEvent(eventMapper.toModel(eventDTO)));
	}
}
