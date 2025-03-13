package edu.study.two.springlab.service.impls;

/*
    @author  matiidenys
    @project  springlab
    @class  BookService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.exception.ApiRequestException;
import edu.study.two.springlab.model.Book;
import edu.study.two.springlab.repository.BookRepository;
import edu.study.two.springlab.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BookService implements IService<Book> {
    @Autowired
    private BookRepository repository;

    @Override
    public Book create(Book book) {
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());

        return repository.save(book);
    }

    @Override
    public Book get(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiRequestException("No records found with " + id + " id"));
    }

    @Override
    public Book update(Book book) {
        book.setUpdatedAt(LocalDateTime.now());

        return repository.save(book);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
}
