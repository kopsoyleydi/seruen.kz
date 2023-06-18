package bek.kino.ticket.two.services;


import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.model.Event;
import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketsService {

    private final TicketsRepoImpl ticketsRepo;
    private final UserService userService;

    private final EventRepository eventRepository;

    public Tickets setNewTicket(String username, Long eventId){
        User user = userService.getCurrentSessionUser();
        Tickets tickets1 = new Tickets();
        Event event = eventRepository.findAllById(eventId);
        int random = (int)(Math.random() * 50 + 1);
        tickets1.setPrimeCodeTicket((long) random);
        tickets1.setUser(user);
        tickets1.setEvent(event);
        return ticketsRepo.addTicket(tickets1);
    }
}
