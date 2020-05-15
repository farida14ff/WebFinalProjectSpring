package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "views/index";
    }

    @GetMapping("/index")
    public String showMain() {
        return "views/index";
    }

    @GetMapping("/login")
    public String login() {
        return "views/login";
    }



}