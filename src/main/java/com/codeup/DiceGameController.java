package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Austin on 1/4/17.
 */

@Controller
public class DiceGameController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "diceGame";
    }

    @GetMapping("/roll-dice/{n}")
    public String showResult(@PathVariable int n, Model model) {

        int randomNumber = 1 + (int)(Math.random() * 6);

        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("number", n);

        return "diceGame";
    }
}
