package edu.study.two.springlab.controller;

/*
    @author  matiidenys
    @project  springlab
    @class  AuthorRestController
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.model.Author;
import edu.study.two.springlab.repository.AuthorRepository;
import edu.study.two.springlab.service.impls.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService service;
    @Autowired
    private AuthorRepository repository;

    @GetMapping("/get")
    private List<Author> showAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private Author showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/create")
    private Author createOne(@RequestBody Author author) {
        return service.create(author);
    }

    @PostMapping("/createBunch")
    private List<Author> createMany(@RequestBody List<Author> author) {
        return repository.insert(author);
    }

    @PutMapping("/update/{id}")
    private Author updateOne(@PathVariable String id, @RequestBody Author author) {
        author.setId(id);

        return service.update(author);
    }

    @GetMapping("/search/byName/{name}")
    private List<Author> showByName(@PathVariable String name){
        return service.getAllByString(name);
    }
    @GetMapping("/search/birthdate/range/{from}&{to}")
    private List<Author> showWithinBirthdateRange(@PathVariable String from, @PathVariable String to){
        return service.getAllWithinBirthdateRange(LocalDate.parse(from), LocalDate.parse(to));
    }

    @GetMapping("/page/{size}&{page}")
    private Page<Author> showAuthorPage(@PathVariable Integer size, @PathVariable Integer page){
        return service.getAuthorPage(size, page);
    }

    @GetMapping("/page/list/{size}&{page}")
    private List<Author> showAuthorPageAsList(@PathVariable Integer size, @PathVariable Integer page){
        return service.getAuthorPageAsList(size, page);
    }
}
