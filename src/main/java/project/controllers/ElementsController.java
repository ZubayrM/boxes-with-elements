package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Elements;
import project.repositories.ElementsRepository;

@RestController("/elements")
public class ElementsController {

    @Autowired
    private ElementsRepository elementsRepository;


    @PostMapping("/add")
    public ResponseEntity addElements(Elements elements){
        Elements save = elementsRepository.save(elements);
        return ResponseEntity.ok(save);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id){
        elementsRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }



    @PutMapping("/update")
    public ResponseEntity updateElement(Elements elements){
        elementsRepository.deleteById(elements.getId());
        Elements save = elementsRepository.save(elements);
        return ResponseEntity.ok(save);
    }
}
