package bek.kino.ticket.two.api;


import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.services.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TicketController {


    private final TicketsRepoImpl ticketsRepo;

    private final TicketsService ticketsService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/bookTicket")
    public String getTicket(@RequestParam(name = "user_email") String username, @RequestParam(name = "event_id") Long eventId){
        ticketsService.setNewTicket(username,eventId);
        return "redirect:/";
    }

    @GetMapping(value = "/getAllTickets")
    public List<Tickets> getAllTickets(){
        return ticketsRepo.getAllTickets();
    }
}
