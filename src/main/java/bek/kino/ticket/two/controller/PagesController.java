package bek.kino.ticket.two.controller;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.dto.HallDTO;
import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PagesController {

	private final ListsForData lists;
	private final EventService eventService;

	private final TicketsService ticketsService;

	private final UserService userService;

	private final HallService hallService;


	@GetMapping(value = "/")
	public String indexPage(Model model) {
		return "index";
	}

	@GetMapping(value = "/403-page")
	public String accessDenied() {
		return "403";
	}

	@GetMapping(value = "/sign-in-page")
	public String signinPage() {
		return "signin";
	}

	@GetMapping(value = "/sign-up-page")
	public String signupPage() {
		return "signup";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/update-password-page")
	public String updatePasswordPage() {
		return "update-password";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getEvent/{id}")
	public String getEventById(@PathVariable(name = "id") Long id, Model model) {
		EventDTO eventDTO = new EventDTO();
		eventDTO = eventService.getEventById(id);
		List<Integer> places = new ArrayList<>();
		List<Integer> listPlace = lists.getPlaces();
		List<TicketDTO> ticketsList = ticketsService.getTicketByEventId(id);
		for (TicketDTO ticketDTO : ticketsList) {
			places.add(ticketDTO.getPlace());
		}
		listPlace.removeAll(places);
		model.addAttribute("places", listPlace);
		model.addAttribute("event", eventDTO);
		return "eventPage";
	}

	@GetMapping(value = "/selectSeat")
	public String selectSeat() {
		return "selectSeat";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/my_tickets")
	public String userTickets(Model model) {
		User user = userService.getCurrentSessionUser();
		model.addAttribute("user", user);
		return "MyTickets";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/admin-event")
	public String adminPanel() {
		return "adminEvent";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/admin-event-detail/{id}")
	public String adminEventDetail(@PathVariable(name = "id") Long id, Model model){
		return "admin-event-detail";
	}
}
