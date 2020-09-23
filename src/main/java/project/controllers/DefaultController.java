package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.model.Elements;
import project.repositories.ElementsRepository;

@org.springframework.stereotype.Controller
class DefaultController {

    @Autowired
    private ElementsRepository elementsRepository;

    @GetMapping("/")
    public String init(Model model){

        Iterable<Elements> all = elementsRepository.getAll();


        model.addAttribute("elementsList", all);
        return "index";
    }


}
