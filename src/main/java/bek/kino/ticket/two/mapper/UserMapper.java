package bek.kino.ticket.two.mapper;


import bek.kino.ticket.two.dto.UserDTO;
import bek.kino.ticket.two.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDTO toDtoUser(User user);

	User toModelUser(UserDTO userDTO);

	List<UserDTO> toDtoListUser(List<User> list);

	List<User> toUserList(List<UserDTO> list);
}
