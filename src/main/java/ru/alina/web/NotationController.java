package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ru.alina.model.Notation;
import ru.alina.security.SecurityUtil;
import ru.alina.service.NotationService;
import ru.alina.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class NotationController {
    private final UserService userService;

    private final NotationService notationService;

    @Autowired
    public NotationController(UserService userService, NotationService notationService) {
        this.userService = userService;
        this.notationService = notationService;
    }


    @GetMapping
    public String getNotation(Model model) {
        System.out.println("getNotation");
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        List<Notation> notations = notationService.getAll(userId);
        model.addAttribute("notations", notations);
        return "home";
    }

    @GetMapping("edit")
    public String getEdit(@RequestParam("id") String id, Model model) {
        model.addAttribute("notation", notationService.get(Long.parseLong(id), userService.getIdByEmail(SecurityUtil.getEmail())));
        return "editNotation";
    }

    @PostMapping("edit")
    public String edit(WebRequest request) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        Long id = Long.parseLong(Objects.requireNonNull(request.getParameter("id")));
        Double weight = Double.parseDouble(Objects.requireNonNull(request.getParameter("weight")));
        LocalDate added = LocalDate.parse(Objects.requireNonNull(request.getParameter("added")));
        Notation notation = new Notation(id, added, weight);
        notationService.save(notation, userId);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Long id) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        notationService.delete(id, userId);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add() {
        return "addNotation";
    }

    @PostMapping("/add")
    public String addSubmit(WebRequest request) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        Double weight = Double.parseDouble(Objects.requireNonNull(request.getParameter("weight")));
        LocalDate added = LocalDate.parse(Objects.requireNonNull(request.getParameter("added")));
        Notation notation = new Notation(added, weight);
        notationService.save(notation, userId);
        return "redirect:/";
    }
}
