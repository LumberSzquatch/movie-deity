package movieDeity.domain.model.controllers;

import movieDeity.Constants;
import movieDeity.domain.model.forms.UserForm;
import movieDeity.interfaces.user.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*
UserController handles all pages from the user directory; account, home, login, registration, and welcome
 */

@Controller
public class UserController {

    @Autowired
    RegistrationService userRegistrationService;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "landing";
    }

    @PostMapping("/signUp")
    public String greetingSubmit(Model model, @Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(userForm);
            return "landing";
        }
        // TODO: Head to service layer; First step is checking if username is taken (will have to fake DB side until service is complete)
        if(userRegistrationService.usernameExists(userForm.getUsername())){
            // return page with error
            model.addAttribute("usernameTaken", Constants.USERNAME_TAKEN);
            model.addAttribute(userForm);
            return "landing";
        }
        return "user/welcome";
    }

}
