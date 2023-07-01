package bek.kino.ticket.two.controller;

import bek.kino.ticket.two.impl.PermissionRepoImpl;
import bek.kino.ticket.two.model.Permission;
import bek.kino.ticket.two.model.User;
import bek.kino.ticket.two.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	private PermissionRepoImpl repo;

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/profile")
	public String profilePage(Model model) {
		User user = userService.getCurrentSessionUser();
		model.addAttribute("user", user);
		return "profile";
	}


	@PostMapping(value = "/to-sign-up")
	public String toSignUp(@RequestParam(name = "user_email") String email,
	                       @RequestParam(name = "user_password") String password,
	                       @RequestParam(name = "user_repeat_password") String repeatPassword,
	                       @RequestParam(name = "user_full_name") String fullName) {
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
			User newUser = userService.addUser(user);
			if (newUser != null) {
				return "redirect:/sign-up-page?success";
			} else {
				return "redirect:/sign-up-page?emailerror";
			}
		} else {
			return "redirect:/sign-up-page?passworderror";
		}
	}

	@PostMapping(value = "/to-update-password")
	public String toUpdatePassword(
			@RequestParam(name = "user_old_password") String oldPassword,
			@RequestParam(name = "user_new_password") String newPassword,
			@RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

		if (newPassword.equals(repeatNewPassword)) {

			User user = userService.updatePassword(newPassword, oldPassword);
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
