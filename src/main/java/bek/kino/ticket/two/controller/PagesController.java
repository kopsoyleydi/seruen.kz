package bek.kino.ticket.two.controller;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PagesController {

	private final EventService eventService;


	private final UserService userService;


	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/home")
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
		EventDTO eventDTO = eventService.getEventById(id);
		List<Integer> listPlace = eventService.listPlaces(id);
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
	public String adminEvent() {
		return "adminEvent";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/admin-event-detail/{id}")
	public String adminEventDetail(@PathVariable(name = "id") Long id, Model model) {
		return "admin-event-detail";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/events-history")
	public String eventsHistory() {
		return "eventsHistory";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/add-balance")
	public String addBalanceToUser() {
		return "Balance";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/admin-panel")
	public String adminPanel(){
		return "admin-panel";
	}
}
