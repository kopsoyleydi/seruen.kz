package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Permission;

import java.util.List;


public interface PermissionRepoInterface {
	Permission getPermissionById(Long id);

	Permission addPermission(Permission permission);

	List<Permission> getAllPermissions();
}
