package ru.alina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import ru.alina.to.ProfileTo;
import ru.alina.model.Activity;
import ru.alina.model.Gender;
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
    public String submitProfileForm(WebRequest request) {
        Long userId = userService.getIdByEmail(SecurityUtil.getEmail());
        Gender gender = Gender.valueOf(request.getParameter("gender").toUpperCase());
        Integer height = Integer.parseInt(request.getParameter("height"));
        Integer age = Integer.parseInt(request.getParameter("age"));
        Activity activity = Activity.valueOf(request.getParameter("activity").toUpperCase());
        Double startWeight = Double.parseDouble(request.getParameter("startWeight"));
        Double desiredWeight = Double.parseDouble(request.getParameter("desiredWeight"));

        Profile profile = new Profile(gender, height, age, activity, startWeight, desiredWeight);
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
