package ru.alina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alina.model.User;
import ru.alina.service.UserService;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService service;

    @Autowired
    public UserDetailsServiceImpl(UserService service) {
        this.service= service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User with email " + username + " not exist"));
        return SecurityUser.fromUser(user);
    }
}
