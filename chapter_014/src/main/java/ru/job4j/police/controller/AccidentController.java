package ru.job4j.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.police.service.AccidentService;

@Controller
public class AccidentController {
    @Autowired
    private AccidentService service;
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("accidentList", service.findAll());
        return "index";
    }
}
