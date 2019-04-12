package com.amisoft.training.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(value="/welcome")
    public String index() {
        return "welcome";
    }
}
