package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.repo_services.UserRepoInterface;
import bek.kino.ticket.two.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepoInterface {


	private final UserRepository userRepository;
	@Override
	public User getUserById(Long id) {
		return userRepository.findAllById(id);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateParam(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
