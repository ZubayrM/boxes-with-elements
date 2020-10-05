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
        System.out.println(byId.get().getGroup().getId());
        return ResponseEntity.ok(byId.orElse(null));
    }


    @PostMapping("/{id}")
    public ResponseEntity addElementToElements(Element element,@PathVariable Long id){
        Optional<Elements> byId = elementsRepository.findById(id);
        element.setGroup(elementsRepository.findById(id).get());
        Element saveE = elementRepository.save(element);

        if (byId.isPresent()){
            Elements elements = byId.get();
            elements.getList().add(saveE);
            Elements save = elementsRepository.save(elements);
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id){
        elementRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity updateElement(Element element){
        Element save = elementRepository.save(element);
        return ResponseEntity.ok(save);
    }
}
