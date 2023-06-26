package bek.kino.ticket.two.controller;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.impl.TicketsRepoImpl;
import bek.kino.ticket.two.mapper.TicketMapper;
import bek.kino.ticket.two.model.Tickets;
import bek.kino.ticket.two.repository.TicketsRepository;
import bek.kino.ticket.two.services.EventService;
import bek.kino.ticket.two.services.ListsForData;
import bek.kino.ticket.two.services.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PagesController {

    private final ListsForData lists;
    private final EventService eventService;

    private final TicketsService ticketsService;

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

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage() {
        return "update-password";
    }

    @GetMapping(value = "/getEvent/{id}")
    public String getEventById(@PathVariable(name = "id") Long id, Model model){
        EventDTO eventDTO = new EventDTO();
        eventDTO = eventService.getEventById(id);
        List<Integer> places = new ArrayList<>();
        List<Integer> listPlace = lists.getPlaces();
        List<TicketDTO> ticketsList = ticketsService.getTicketByEventId(eventDTO.getId());
        for (TicketDTO ticketDTO : ticketsList) {
            places.add(ticketDTO.getPlace());
        }
        listPlace.removeAll(places);
        model.addAttribute("places",listPlace);
        model.addAttribute("event",eventDTO);
        return "eventPage";
    }

    @GetMapping(value = "/selectSeat")
    public String selectSeat(){
        return "selectSeat";
    }

}
