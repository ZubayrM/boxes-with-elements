package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Element;
import project.repositories.ElementRepository;

import java.util.Optional;

@RestController
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementRepository elementRepository;

    @GetMapping("/{id}")
    public ResponseEntity getElement(@PathVariable Long id){
        Optional<Element> byId = elementRepository.findById(id);
        System.out.println(byId.get().getGroupId().getId());
        return ResponseEntity.ok(byId.orElse(null));
    }


    @PostMapping
    public ResponseEntity addElement(Element element){
        Element save = elementRepository.save(element);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id){
        System.out.println(id);
        elementRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }



    @PutMapping("/update")
    public ResponseEntity updateElement(Element element){
        System.out.println(element);
        Element save = elementRepository.save(element);
        return ResponseEntity.ok(save);
    }
}
