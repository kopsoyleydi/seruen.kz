package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.impl.PermissionRepoImpl;
import bek.kino.ticket.two.mapper.PermissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

	private final PermissionRepoImpl repo;

	private final PermissionMapper mapper;


	public List<PermissionDTO> getAllPermissions(){
		return mapper.toDtoList(repo.getAllPermissions());
	}
}
