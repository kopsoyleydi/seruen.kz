package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Permission;


public interface PermissionRepoInterface {
	Permission getPermissionById(Long id);
}
