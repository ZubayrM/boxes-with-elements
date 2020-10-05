package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Elements;
import project.repositories.ElementsRepository;

@RestController
@RequestMapping("/elements")
public class ElementsController {

    private long globalId = 0;

    @Autowired
    private ElementsRepository elementsRepository;




    @PostMapping
    public ResponseEntity addElements(Elements elements){
        Elements save = elementsRepository.save(elements);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        elementsRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }











}
