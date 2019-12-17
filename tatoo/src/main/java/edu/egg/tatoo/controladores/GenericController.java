package edu.egg.tatoo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GenericController {

    @GetMapping("/login")
    public String login() {
        return "login.html";
        
    }

    @PostMapping("/in")
    public String menu() {
        System.out.println("hola");
        
        return "menu.html";
        
    }

}