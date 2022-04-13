package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alina.model.Notation;
import ru.alina.security.SecurityUtil;
import ru.alina.service.NotationService;
import ru.alina.service.UserService;
import ru.alina.to.NotationTo;
import ru.alina.util.NotationUtil;

import java.util.List;

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
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        List<Notation> notations = notationService.getAll(userId);
        List<NotationTo> notationTos = NotationUtil.getNotationTos(notations);
        model.addAttribute("notations", notationTos);
        return "home";
    }

    @GetMapping("editNotation")
    public String getEdit(@RequestParam("id") String id, Model model) {
        model.addAttribute("notation", notationService.get(Long.parseLong(id), userService.getIdByEmail(SecurityUtil.getEmail())));
        return "editNotation";
    }


    @GetMapping("deleteNotation")
    public String delete(@RequestParam("id") Long id) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        notationService.delete(id, userId);
        return "redirect:/";
    }

    @GetMapping("/addNotation")
    public String add() {
        return "addNotation";
    }

    @PostMapping("/addNotation")
    public String addSubmit(@ModelAttribute Notation notation, BindingResult result) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        if (result.hasErrors()) {
            return "redirect:/addNotation";
        }
        notationService.save(notation, userId);
        return "redirect:/";
    }
}
