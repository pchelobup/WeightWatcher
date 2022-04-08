package ru.alina.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

    public static String getEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //TODO better throw ex
        if (auth == null) {
            return null;
        }
        org.springframework.security.core.userdetails.User userDetails = (User) auth.getPrincipal();
        return userDetails.getUsername();
    }
}
