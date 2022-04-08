package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import ru.alina.model.Role;
import ru.alina.model.User;
import ru.alina.service.UserService;

import java.util.Collections;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "singIn";
    }

    @GetMapping("/registration")
    public String registration() {
        return "signUp";
    }

    @PostMapping("/registration")
    public String SingIn(WebRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");
        //TODO test on null
        if (!password.equals(passwordConfirm) || userService.isLoginExist(email)) {
            //TODO оповестить пользователя
            return "signUp";
        }

        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(password);
        User user = new User(email, hashPass);
        user.setRoles(Collections.singleton(Role.USER));
        //TODO оповестить и записать в лог если юзер null
        userService.save(user);
        return "singIn";
    }
}
