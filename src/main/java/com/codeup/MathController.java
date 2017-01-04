package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Austin on 1/4/17.
 */

@Controller
public class MathController {

    @GetMapping("/add/{number}/and/{numberTwo}")
    @ResponseBody
    public int add(@PathVariable int number, @PathVariable int numberTwo) {
        return number + numberTwo;
    }

    @GetMapping("/subtract/{number}/from/{numberTwo}")
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int numberTwo) {
        return numberTwo - number;
    }

    @GetMapping("/multiply/{number}/and/{numberTwo}")
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int numberTwo) {
        return number * numberTwo;
    }

    @GetMapping("/divide/{number}/by/{numberTwo}")
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int numberTwo) {
        return number / numberTwo;
    }

}
