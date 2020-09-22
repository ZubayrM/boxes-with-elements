package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Element;
import project.repositories.ElementRepository;

@RestController("/element")
public class ElementController {

    @Autowired
    private ElementRepository elementRepository;


    @PostMapping("/add")
    public ResponseEntity addElement(Element element){
        Element save = elementRepository.save(element);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id){
        elementRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }



    @PutMapping("/update")
    public ResponseEntity updateElement(Element element){
        elementRepository.deleteById(element.getId());
        Element save = elementRepository.save(element);
        return ResponseEntity.ok(save);
    }
}
