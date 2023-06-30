package bek.kino.ticket.two.mapper;

import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.model.Event;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
	EventDTO toDto(Event event);

	Event toModel(EventDTO eventDTO);

	List<EventDTO> toDtoList(List<Event> list);

	List<Event> toEventList(List<EventDTO> list);
}
