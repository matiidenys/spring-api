package edu.study.two.springlab.controller;

/*
    @author  matiidenys
    @project  springlab
    @class  BookshelfItemsController
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.model.BookshelfItem;
import edu.study.two.springlab.service.impls.BookshelfItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookshelf-items")
public class BookshelfItemsController {
    @Autowired
    private BookshelfItemService service;

    @GetMapping("/get")
    private List<BookshelfItem> showAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    private BookshelfItem showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/create")
    private BookshelfItem createOne(@RequestBody BookshelfItem bookshelfItem) {
        return service.create(bookshelfItem);
    }

    @PutMapping("/update/{id}")
    private BookshelfItem updateOne(@PathVariable String id, @RequestBody BookshelfItem bookshelfItem) {
        bookshelfItem.setId(id);

        return service.update(bookshelfItem);
    }
}
