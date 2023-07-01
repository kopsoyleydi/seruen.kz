package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Permission;

import java.util.Optional;

public interface PermissionRepoInterface {
	Permission getPermissionById(Long id);
}
