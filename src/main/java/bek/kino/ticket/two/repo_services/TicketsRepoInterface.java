package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Tickets;

import java.util.List;

public interface TicketsRepoInterface {
     List<Tickets> getAllTickets();

     Tickets getTicketById(Long id);

     Tickets addTicket(Tickets tickets);

     Tickets getTicketByUserId(Long id);
}
