package com.redriver.challenge.controller;

import com.redriver.challenge.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({ "/", "/index" })
public class WelcomeController {

    @GetMapping
    public String main(Model model) {
        //model.addAttribute("student", new Student());
        return "index";
    }


}

