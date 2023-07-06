package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.Balance;
import bek.kino.ticket.two.BodySample.ImgUpdateBody;
import bek.kino.ticket.two.BodySample.SamplePermissionId;
import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.dto.UserDTO;
import bek.kino.ticket.two.services.UserService;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getCurrentUser/{id}")
	public UserDTO getCurrentSessionUser(@PathVariable(name = "id") Long id){
		return userService.getUserById(id);
	}

	@GetMapping(value = "/getAllUsers")
	public List<MainUserDTO> getAllUsers(){
		return userService.getAllUsers();
	}

	@PutMapping(value = "/assign")
	public MainUserDTO assign(@RequestBody SamplePermissionId samplePermissionId){
		return userService.assign(samplePermissionId);
	}

	@DeleteMapping(value = "/deletePer")
	public MainUserDTO deletePer(@RequestBody SamplePermissionId samplePermissionId){
		return userService.deletePer(samplePermissionId);
	}

}
