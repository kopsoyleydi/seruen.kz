package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.impl.PermissionRepoImpl;
import bek.kino.ticket.two.impl.UserRepoImpl;
import bek.kino.ticket.two.mapper.PermissionMapper;
import bek.kino.ticket.two.model.Permission;
import bek.kino.ticket.two.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

	private final PermissionRepoImpl repo;

	private final PermissionMapper mapper;

	private final UserRepoImpl userRepo;

	public PermissionDTO assignPermission(Long userId, Long permissionId) {
		User user = userRepo.getUserById(userId);
		Permission permission = repo.getPermissionById(permissionId);
		if (user.getPermissions() != null && user.getPermissions().size() > 0) {
			if (!user.getPermissions().contains(permission)) {
				user.getPermissions().add(permission);
			}
		} else {
			List<Permission> permissionList = new ArrayList<>();
			permissionList.add(permission);
			user.setPermissions(permissionList);
		}
		return mapper.toDto(repo.addPermission(permission));
	}

	public PermissionDTO un_assignPermission(Long userId, Long permissionId) {
		User user = userRepo.getUserById(userId);
		Permission permission = repo.getPermissionById(permissionId);
		if (user.getPermissions() != null && user.getPermissions().size() > 0) {
			user.getPermissions().remove(permission);
		}
		return mapper.toDto(repo.addPermission(permission));
	}

	public List<PermissionDTO> getNotSelectCurrentUserPermission(Long userId) {
		User user = userRepo.getUserById(userId);
		List<Permission> list = repo.getAllPermissions();
		List<Permission> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (!user.getPermissions().get(1).getRole().contains(list.get(i).getRole())) {
				list1.add(i,list.get(i));
			}
		}
		return mapper.toDtoList(list1);
	}

	public List<PermissionDTO> getAllPermissions(){
		return mapper.toDtoList(repo.getAllPermissions());
	}
}
