package com.codeup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Austin on 1/11/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Users usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/create")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("/create")
    public String registerNewUser(@Valid User newUser, Errors validation, Model model){

        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("user", newUser);
            return "users/create";
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        usersDao.save(newUser);
        return "redirect:/login";
    }


}
