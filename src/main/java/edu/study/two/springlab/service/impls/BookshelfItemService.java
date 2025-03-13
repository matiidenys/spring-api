package edu.study.two.springlab.service.impls;

/*
    @author  matiidenys
    @project  springlab
    @class  BookshelfItemService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.exception.ApiRequestException;
import edu.study.two.springlab.model.BookshelfItem;
import edu.study.two.springlab.repository.BookshelfItemRepository;
import edu.study.two.springlab.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookshelfItemService implements IService<BookshelfItem> {
    @Autowired
    private BookshelfItemRepository repository;

    @Override
    public BookshelfItem create(BookshelfItem bookshelfItem) {
        bookshelfItem.setCreatedAt(LocalDateTime.now());
        bookshelfItem.setUpdatedAt(LocalDateTime.now());

        return repository.save(bookshelfItem);
    }

    @Override
    public BookshelfItem get(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiRequestException("No records found with " + id + " id"));
    }

    @Override
    public BookshelfItem update(BookshelfItem bookshelfItem) {
        bookshelfItem.setUpdatedAt(LocalDateTime.now());

        return repository.save(bookshelfItem);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<BookshelfItem> getAll() {
        return repository.findAll();
    }
}
