package movieDeity.domain.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
UserController handles all pages from the user directory; account, home, login, registration, and welcome
 */

@Controller
public class UserController {

    @RequestMapping("/")
    public String landing() {
        return "landing";
    }

}
