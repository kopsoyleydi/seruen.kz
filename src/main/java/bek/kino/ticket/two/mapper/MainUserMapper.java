package bek.kino.ticket.two.mapper;


import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainUserMapper {
    MainUserDTO toDtoUser(User user);
    User toModelUser(MainUserDTO userDTO);
    List<MainUserDTO> toDtoListUser(List<User> list);
    List<User> toUserList(List<MainUserDTO> list);
}
