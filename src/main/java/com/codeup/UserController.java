package com.codeup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Austin on 1/11/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public Users usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/create")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("/create")
    public String registerNewUser(@ModelAttribute User newUser){

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        usersDao.save(newUser);
        return "redirect:/user/login";
    }


}
