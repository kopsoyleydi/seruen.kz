package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.BodySample.TicketBody;
import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.services.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TicketController {


    private final TicketsRepoImpl ticketsRepo;

    private final TicketsService ticketsService;

    @PostMapping(value = "/bookTicket")
    public String getTicket(@RequestParam(name = "user_email") String username, @RequestParam(name = "event_id") Long eventId){
        ticketsService.setNewTicket(username,eventId);
        return "redirect:/";
    }

    @GetMapping(value = "/getAllTickets")
    public List<TicketDTO> getAllTickets(){
        return ticketsService.getTickets();
    }

    @PostMapping(value = "/addTicket")
    public Tickets addTicket(@RequestBody TicketBody tickets){
        return ticketsService.addTicket(tickets);
    }
}
