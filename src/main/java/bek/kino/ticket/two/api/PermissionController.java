package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.Sample;
import bek.kino.ticket.two.BodySample.SamplePermissionId;
import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PermissionController {

	private final PermissionService service;

	@GetMapping(value = "/getNotSelectPermission/{id}")
	public List<PermissionDTO> getNotSelectCurrentUserPermission(@PathVariable(name = "id") Long id){
		return service.getNotSelectCurrentUserPermission(id);
	}

	@GetMapping(value = "/getAllPermissions")
	public List<PermissionDTO> getAllPermissions(){
		return service.getAllPermissions();
	}

	@PostMapping(value = "/assignPermission")
	public PermissionDTO assignPermission(@RequestBody SamplePermissionId permissionId){
		return service.assignPermission(permissionId.getUser_id(),permissionId.getPermission_id());
	}

	@PostMapping(value = "/un_assignPermission")
	public PermissionDTO un_assignPermission(@RequestBody SamplePermissionId permissionId){
		return service.un_assignPermission(permissionId.getUser_id(),permissionId.getPermission_id());
	}


}
