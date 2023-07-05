package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.User;

import java.util.List;

public interface UserRepoInterface {
	User getUserById(Long id);
	User addUser(User user);
	List<User> getAllUsers();

	User updateParam(User user);

	User getUserByEmail(String email);
}
