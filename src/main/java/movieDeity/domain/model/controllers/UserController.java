package movieDeity.domain.model.controllers;

import movieDeity.application.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
UserController handles all pages from the user directory; account, home, login, registration, and welcome
 */

@Controller
public class UserController {

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("newUser", new User());
        return "landing";
    }

    @PostMapping("/signUp")
    public String greetingSubmit(@ModelAttribute User user) {
        return "user/welcome";
    }

}
