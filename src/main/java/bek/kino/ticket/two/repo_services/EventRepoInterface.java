package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.model.Event;

import java.util.List;

public interface EventRepoInterface {
    List<Event> getAllEvents();
    Event addEvent(Event event);
}
