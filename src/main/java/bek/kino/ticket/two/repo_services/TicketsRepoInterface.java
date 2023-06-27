package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Tickets;

import java.util.List;

public interface TicketsRepoInterface {
     List<Tickets> getAllTickets();

     Tickets getTicketById(Long id);

     Tickets addTicket(Tickets tickets);


     List<Tickets> getTicketByEventId(Long id);

     List<Tickets> getAllTicketByUserId(Long id);
}
