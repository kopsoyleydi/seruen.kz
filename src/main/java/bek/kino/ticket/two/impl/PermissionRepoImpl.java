package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Permission;
import bek.kino.ticket.two.repo_services.PermissionRepoInterface;
import bek.kino.ticket.two.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionRepoImpl implements PermissionRepoInterface {

	private final PermissionRepository repository;
	@Override
	public Permission getPermissionById(Long id) {
		return repository.findAllById(id);
	}
}
