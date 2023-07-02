package bek.kino.ticket.two.services;


import bek.kino.ticket.two.EmailTicketSender;
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

	private final EmailTicketSender sender;

	private final ListsForData lists;
	private final EventRepository eventRepository;

	private final BookingSystem bookingSystem;

	public TicketDTO addTicket(TicketBody ticketBody) {
		User user = (User) userService.loadUserByUsername(ticketBody.getUsername());
		if(user != null){
			Tickets tickets1 = new Tickets();
			Event event = eventRepository.findAllById(ticketBody.getId());
			if (bookingSystem.minusBalance(user, ticketBody.getPrice())) {
				int random = (int) (Math.random() * 50 + 1);
				tickets1.setPrimeCodeTicket((long) random);
				tickets1.setUser(user);
				tickets1.setEvent(event);
				lists.minusPlace(ticketBody.getPlace());
				tickets1.setPlace(ticketBody.getPlace());
				sender.sendEmail(user.getEmail(), "Your ticket",tickets1);
				return mapper.toDto(ticketsRepo.addTicket(tickets1));
			}
		}
		return null;
	}

	public List<TicketDTO> getTickets() {
		return mapper.toDtoList(ticketsRepo.getAllTickets());
	}


	public TicketDTO getTicketByUserId(Long id) {
		return mapper.toDto(ticketsRepo.getTicketById(id));
	}

	public List<TicketDTO> getTicketByEventId(Long id) {
		return mapper.toDtoList(ticketsRepo.getTicketByEventId(id));
	}

	public List<TicketDTO> getAllTicketByUserId(Long id) {
		return mapper.toDtoList(ticketsRepo.getAllTicketByUserId(id));
	}
	public List<TicketDTO> getAllActivityTicketsByUserId(Long id){
		return mapper.toDtoList(ticketsRepo.getAllActivityTicketsByUserId(id));
	}

}
