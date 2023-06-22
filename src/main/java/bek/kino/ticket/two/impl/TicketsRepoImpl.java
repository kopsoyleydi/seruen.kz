package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.repo_services.TicketsRepoInterface;
import bek.kino.ticket.two.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsRepoImpl implements TicketsRepoInterface {

    @Autowired
    private TicketsRepository ticketsRepository;
    @Override
    public List<Tickets> getAllTickets() {
        return ticketsRepository.findAll();
    }

    @Override
    public Tickets getTicketById(Long id) {
        return ticketsRepository.findTicketsById(id);
    }

    @Override
    public Tickets addTicket(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }

    @Override
    public Tickets getTicketByUserId(Long id) {
        return ticketsRepository.findAllByUserId(id);
    }
}
