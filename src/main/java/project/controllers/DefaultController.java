package project.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
class DefaultController {

    @GetMapping("/")
    public String init(Model model){
        return "index";
    }


}
