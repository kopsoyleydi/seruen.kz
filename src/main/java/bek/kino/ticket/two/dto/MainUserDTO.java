package bek.kino.ticket.two.dto;


import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainUserDTO {

	private Long id;
	private String email;
	private String password;
	private String fullName;
	private String imgLink;
	@ManyToMany
	private List<PermissionDTO> permissions;
}
