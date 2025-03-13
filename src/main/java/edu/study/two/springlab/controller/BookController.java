package edu.study.two.springlab.controller;

/*
    @author  matiidenys
    @project  springlab
    @class  BookController
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.model.Book;
import edu.study.two.springlab.service.impls.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/get")
    private List<Book> showAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private Book showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/create")
    private Book createOne(@RequestBody Book book) {
        return service.create(book);
    }

    @PutMapping("/update/{id}")
    private Book updateOne(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);

        return service.update(book);
    }
}
