package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alina.service.UserService;

@Controller
public class Test {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String test() {
        System.out.println(userService.get(1));
        return "welcome";
    }
}
