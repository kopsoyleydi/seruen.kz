package bek.kino.ticket.two.mapper;


import bek.kino.ticket.two.dto.PermissionDTO;
import bek.kino.ticket.two.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
	PermissionDTO toDto(Permission permission);

	Permission toModel(PermissionDTO permissionDTO);

	List<PermissionDTO> toDtoList(List<Permission> list);

	List<Permission> toPermissionList(List<PermissionDTO> list);
}
