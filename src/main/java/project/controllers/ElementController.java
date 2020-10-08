package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Element;
import project.model.Elements;
import project.repositories.ElementRepository;
import project.repositories.ElementsRepository;

import java.util.Optional;

@RestController
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private ElementsRepository elementsRepository;

    @GetMapping("/{id}")
    public ResponseEntity getElement(@PathVariable Long id){
        Optional<Element> byId = elementRepository.findById(id);
        return ResponseEntity.ok(byId.orElse(null));
    }


    @PostMapping("/{id}")
    public ResponseEntity addElementToElements(Element element,@PathVariable Long id){
        element.setGroup(elementsRepository.findById(id).get());
        elementRepository.save(element);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id){
        elementRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity updateElement(Element element){
        elementRepository.save(element);
        return ResponseEntity.ok(true);
    }
}
