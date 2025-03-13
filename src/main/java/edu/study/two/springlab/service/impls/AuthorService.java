package edu.study.two.springlab.service.impls;

/*
    @author  matiidenys
    @project  springlab
    @class  AuthorService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.annotation.AuthorGetAnnotation;
import edu.study.two.springlab.exception.ApiRequestException;
import edu.study.two.springlab.model.Author;
import edu.study.two.springlab.repository.AuthorRepository;
import edu.study.two.springlab.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IService<Author> {
    @Autowired
    private AuthorRepository repository;

    @Override
    public Author create(Author author) {
        author.setCreatedAt(LocalDateTime.now());
        author.setUpdatedAt(LocalDateTime.now());

        return repository.save(author);
    }

    @Override
    @AuthorGetAnnotation
    public Author get(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiRequestException("No records found with " + id + " id"));
    }

    @Override
    public Author update(Author author) {
        author.setUpdatedAt(LocalDateTime.now());

        return repository.save(author);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    @AuthorGetAnnotation
    public List<Author> getAll() {
        return repository.findAll();
    }

    @AuthorGetAnnotation
    public List<Author> getAllByString(String str){
        return this.getAll().stream()
                .filter(author -> author.getFirstName().contains(str))
                .collect(Collectors.toList());
    }

    @AuthorGetAnnotation
    public List<Author> getAllSortedByBirthdate(boolean ascending) {
        if (ascending){
            return this.getAll().stream()
                    .sorted(Comparator.comparing(Author::getBirthdate))
                    .collect(Collectors.toList());
        }

        return this.getAll().stream()
                .sorted(Comparator.comparing(Author::getBirthdate).reversed())
                .collect(Collectors.toList());

    }

    @AuthorGetAnnotation
    public List<Author> getAllWithinBirthdateRange(LocalDate from, LocalDate to){
        return this.getAll().stream()
                .filter(author -> author.getBirthdate().isAfter(from) && author.getBirthdate().isBefore(to))
                .collect(Collectors.toList());

    }

    @AuthorGetAnnotation
    public Page<Author> getAuthorPage(int size, int page){
        return repository.findAll(PageRequest.of(page, size, Sort.by("firstName")));
    }

    @AuthorGetAnnotation
    public List<Author> getAuthorPageAsList(int size, int page){
        return getAuthorPage(size, page).getContent();
    }
}
