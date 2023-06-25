package bek.kino.ticket.two.controller;


import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PagesController {

    private final EventService eventService;

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
        model.addAttribute("event",eventDTO);
        return "eventPage";
    }

}
