package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import ru.alina.model.Role;
import ru.alina.model.User;
import ru.alina.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Controller
public class AuthController {
    private UserService userService;

    protected AuthenticationManager authenticationManager;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
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
    public String SingIn(HttpServletRequest httpServletRequest) {
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        String passwordConfirm = httpServletRequest.getParameter("password-confirm");
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
        authWithAuthManager(httpServletRequest, email, password);
        return "redirect:/";
    }

    public void authWithAuthManager(HttpServletRequest request, String username, String password) {
        try{
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
            authToken.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e){
            e.getStackTrace();
        }


    }
}
