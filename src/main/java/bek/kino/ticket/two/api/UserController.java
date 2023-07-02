package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.Balance;
import bek.kino.ticket.two.BodySample.ImgUpdateBody;
import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.dto.UserDTO;
import bek.kino.ticket.two.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/set-img")
	public MainUserDTO updateProfileImg(@RequestBody ImgUpdateBody imgUpdateBody) {
		return userService.updateImgInProfile(imgUpdateBody);
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/plusBalance")
	public MainUserDTO plusBalance(@RequestBody Balance balance) {
		return userService.topToBalance(balance);
	}

	@GetMapping(value = "/getCurrentUser/{id}")
	public UserDTO getCurrentSessionUser(@PathVariable(name = "id") Long id){
		return userService.getUserById(id);
	}

}
