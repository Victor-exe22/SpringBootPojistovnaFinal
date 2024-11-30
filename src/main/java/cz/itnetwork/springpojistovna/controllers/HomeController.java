package cz.itnetwork.springpojistovna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/contact")
    public String renderContact() {
        return "pages/home/contact";
    }


}
