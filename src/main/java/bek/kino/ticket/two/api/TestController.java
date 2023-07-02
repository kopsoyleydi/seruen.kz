package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final TicketMapper mapper;
	private final TicketsRepoImpl repo;

	@GetMapping(value = "/testTickets")
	public List<TicketDTO> getTicketById() {
		return mapper.toDtoList(repo.getTicketByEventId(5L));
	}
}
