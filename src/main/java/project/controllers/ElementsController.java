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
@RequestMapping("/elements")
public class ElementsController {

    private long globalId = 0;

    @Autowired
    private ElementsRepository elementsRepository;

    @Autowired
    private ElementRepository elementRepository;


    @GetMapping("/{id}")
    public ResponseEntity getElements(@PathVariable Long id){
        Optional<Elements> byId = elementsRepository.findById(id);
        return ResponseEntity.ok(byId.orElse(null));
    }

    @PostMapping
    public ResponseEntity addElements(Elements elements){
        Elements save = elementsRepository.save(elements);
        return ResponseEntity.ok(save);
    }


    @PostMapping("/{id}")
    public ResponseEntity addElementToElements(Element element,@PathVariable Long id){
        Optional<Elements> byId = elementsRepository.findById(id);
        element.setGroupId(elementsRepository.findById(id).get());
        element.setId(++globalId);
        System.out.println(element.getId());
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
        elementsRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }



    @PutMapping("/update")
    public ResponseEntity updateElement(@RequestParam Elements elements){
        elementsRepository.deleteById(elements.getId());
        Elements save = elementsRepository.save(elements);
        return ResponseEntity.ok(save);
    }
}
