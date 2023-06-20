package bek.kino.ticket.two.services;

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

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
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

    public void updateUser(User user){
        userRepository.save(user);
    }
}
