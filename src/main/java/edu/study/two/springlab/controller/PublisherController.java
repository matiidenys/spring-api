package edu.study.two.springlab.controller;

/*
    @author  matiidenys
    @project  springlab
    @class  PublisherController
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.model.Publisher;
import edu.study.two.springlab.service.impls.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {
    @Autowired
    private PublisherService service;

    @GetMapping("/get")
    private List<Publisher> showAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private Publisher showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/create")
    private Publisher createOne(@RequestBody Publisher publisher) {
        return service.create(publisher);
    }

    @PutMapping("/update/{id}")
    private Publisher updateOne(@PathVariable String id, @RequestBody Publisher publisher) {
        publisher.setId(id);

        return service.update(publisher);
    }
}
