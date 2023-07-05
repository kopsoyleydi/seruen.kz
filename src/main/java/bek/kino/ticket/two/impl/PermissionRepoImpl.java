package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Permission;
import bek.kino.ticket.two.repo_services.PermissionRepoInterface;
import bek.kino.ticket.two.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionRepoImpl implements PermissionRepoInterface {

	private final PermissionRepository repository;

	@Override
	public Permission getPermissionById(Long id) {
		return repository.findAllById(id);
	}

	@Override
	public Permission addPermission(Permission permission) {
		return repository.save(permission);
	}

	@Override
	public List<Permission> getAllPermissions() {
		return repository.findAll();
	}

}
