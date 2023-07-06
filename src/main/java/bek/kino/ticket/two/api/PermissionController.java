package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PermissionController {

	private final PermissionService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/getAllPermissions")
	public List<PermissionDTO> getAllPermissions(){
		return service.getAllPermissions();
	}


}
