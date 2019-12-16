package edu.egg.tatoo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tatoo")
@Controller
public class GenericController {

    @GetMapping("/")
    public String login() {
        return "login.html";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu.html";
    }

}