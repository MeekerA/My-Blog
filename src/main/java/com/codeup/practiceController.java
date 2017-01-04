package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Austin on 1/4/17.
 */
@Controller
public class practiceController {

    @GetMapping("/conditions/{number}")
    public String conditions(@PathVariable String  number, Model model){
        model.addAttribute("status", number);
        return "conditions";
    }

    @GetMapping("/formatting")
    public String formatting(Model model){
        model.addAttribute("productName", "DVD Player");
        model.addAttribute("productDate", "11/12/1990");
        model.addAttribute("productPrice", "152.23");
        return "formatting";
    }

}
