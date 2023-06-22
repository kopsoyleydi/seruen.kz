package bek.kino.ticket.two.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PagesController {

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

}
