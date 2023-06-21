package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.ImgUpdateBody;
import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/set-img")
    public MainUserDTO updateProfileImg(@RequestBody ImgUpdateBody imgUpdateBody){
        return userService.updateImgInProfile(imgUpdateBody);
    }
}
