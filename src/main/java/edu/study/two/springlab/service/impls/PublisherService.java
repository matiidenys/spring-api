package edu.study.two.springlab.service.impls;

/*
    @author  matiidenys
    @project  springlab
    @class  PublisherService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.exception.ApiRequestException;
import edu.study.two.springlab.model.Publisher;
import edu.study.two.springlab.repository.PublisherRepository;
import edu.study.two.springlab.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublisherService implements IService<Publisher> {
    @Autowired
    private PublisherRepository repository;

    @Override
    public Publisher create(Publisher publisher) {
        publisher.setCreatedAt(LocalDateTime.now());
        publisher.setUpdatedAt(LocalDateTime.now());

        return repository.save(publisher);
    }

    @Override
    public Publisher get(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiRequestException("No records found with " + id + " id"));
    }

    @Override
    public Publisher update(Publisher publisher) {
        publisher.setUpdatedAt(LocalDateTime.now());

        return repository.save(publisher);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Publisher> getAll() {
        return repository.findAll();
    }
}
