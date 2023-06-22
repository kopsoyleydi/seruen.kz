package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.mapper.TicketMapper;
import bek.kino.ticket.two.model.Event;
import bek.kino.ticket.two.BodySample.TicketBody;
import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketsService {

    private final TicketsRepoImpl ticketsRepo;
    private final UserService userService;
    private final TicketMapper mapper;

    private final EventRepository eventRepository;

    public TicketDTO addTicket(TicketBody ticketBody){
        String username = ticketBody.getUsername();
        User user = (User) userService.loadUserByUsername(username);
        Tickets tickets1 = new Tickets();
        Event event = eventRepository.findAllById(ticketBody.getId());
        int random = (int)(Math.random() * 50 + 1);
        tickets1.setPrimeCodeTicket((long) random);
        tickets1.setUser(user);
        tickets1.setEvent(event);
        return mapper.toDto(ticketsRepo.addTicket(tickets1));
    }
    public List<TicketDTO> getTickets(){
        return mapper.toDtoList(ticketsRepo.getAllTickets());
    }

    public TicketDTO getTicketByUserId(){
        return mapper.toDto(ticketsRepo.getTicketByUserId(userService.getCurrentSessionUser().getId()));
    }
}
