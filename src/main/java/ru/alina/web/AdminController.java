package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alina.model.Role;
import ru.alina.model.Status;
import ru.alina.model.User;
import ru.alina.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        userService.delete(Long.parseLong(id));
        return "redirect:/admin/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") String id, Model model) {
        User user = userService.get(Long.parseLong(id));
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String submitEdit(@RequestParam String id,
                             @RequestParam String email,
                             @RequestParam Status status,
                             @RequestParam Role[] role) {

        User user = userService.get(Long.parseLong(id));
        user.setEmail(email);
        user.setStatus(status);
        user.setRoles(Set.of(role));
        userService.save(user);

        return "redirect:/admin/users";
    }
}
