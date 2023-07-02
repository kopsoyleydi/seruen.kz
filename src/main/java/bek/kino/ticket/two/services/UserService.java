package bek.kino.ticket.two.services;

import bek.kino.ticket.two.BodySample.Balance;
import bek.kino.ticket.two.BodySample.ImgUpdateBody;
import bek.kino.ticket.two.dto.MainUserDTO;
import bek.kino.ticket.two.dto.UserDTO;
import bek.kino.ticket.two.impl.PermissionRepoImpl;
import bek.kino.ticket.two.mapper.MainUserMapper;
import bek.kino.ticket.two.mapper.UserMapper;
import bek.kino.ticket.two.model.Permission;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MainUserMapper mapper;
	@Autowired
	private PermissionRepoImpl repo;
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User Not found");
		}
	}

	public User addUser(User user) {
		User checkUser = userRepository.findByEmail(user.getEmail());
		if (checkUser == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
		return null;
	}

	public User updatePassword(String newPassword, String oldPassword) {

		User currentUser = getCurrentSessionUser();
		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
			currentUser.setPassword(passwordEncoder.encode(newPassword));
			return userRepository.save(currentUser);
		}
		return null;
	}

	public User getCurrentSessionUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User user = (User) authentication.getPrincipal();
			if (user != null) {
				return user;
			}
		}
		return null;
	}

	public MainUserDTO topToBalance(Balance balance){
		User user = userRepository.findAllById(balance.getUser_id());
		user.setBalance(balance.getBalance() + user.getBalance());
		return mapper.toDtoUser(userRepository.save(user));
	}

	public MainUserDTO updateImgInProfile(ImgUpdateBody imgUpdateBody) {
		User user = null;
		user = (User) loadUserByUsername(imgUpdateBody.userEmail);
		user.setImgLink(imgUpdateBody.link);
		return mapper.toDtoUser(userRepository.save(user));
	}

	public UserDTO getUserById(Long id){
		return userMapper.toDtoUser(userRepository.findAllById(id));
	}

	public String signUpService(String email,String password,String repeatPassword,String fullName){
		if (password.equals(repeatPassword)) {
			User user = new User();
			user.setEmail(email);
			user.setFullName(fullName);
			user.setPassword(password);
			user.setImgLink(
					"https://yt3.ggpht.com/a/AGF-l78RCnBXwItPz7NOMEmGVDdZ6Qaoss63865a8Q=s900-c-k-c0xffffffff-no-rj-mo");
			Permission permission = repo.getPermissionById(3L);
			List<Permission> permissionList = new ArrayList<>();
			permissionList.add(permission);
			user.setPermissions(permissionList);
			User newUser = addUser(user);
			if (newUser != null) {
				return "redirect:/sign-up-page?success";
			} else {
				return "redirect:/sign-up-page?emailerror";
			}
		} else {
			return "redirect:/sign-up-page?passworderror";
		}
	}

	public String updatePassword(String oldPassword,String newPassword,String repeatNewPassword){
		if (newPassword.equals(repeatNewPassword)) {

			User user = updatePassword(newPassword, oldPassword);
			if (user != null) {
				return "redirect:/update-password-page?success";
			} else {
				return "redirect:/update-password-page?oldpassworderror";
			}

		} else {
			return "redirect:/update-password-page?passwordmismatch";
		}
	}
}
