package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alina.to.ProfileTo;
import ru.alina.model.Profile;
import ru.alina.security.SecurityUtil;
import ru.alina.service.ProfileService;
import ru.alina.service.UserService;

@Controller
public class ProfileController {

    private final UserService userService;

    private final ProfileService profileService;

    @Autowired
    public ProfileController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @GetMapping("/profileForm")
    public String getProfileForm() {
        return "profileForm";
    }

    @PostMapping("/profileForm")
    public String submitProfileForm(@ModelAttribute Profile profile, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/profileForm";
        }
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        profileService.save(profile, userId);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        ProfileTo profileTo = new ProfileTo(profileService.get(userId));
        model.addAttribute("profileTo", profileTo);
        return "profile";
    }

    @GetMapping("/editProfile")
    public String getEditForm(Model model) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        model.addAttribute("profile", profileService.get(userId));
        return "editProfile";
    }




}
