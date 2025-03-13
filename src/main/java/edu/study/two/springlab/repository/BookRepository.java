package edu.study.two.springlab.repository;

/*
    @author  matiidenys
    @project  springlab
    @class  BookRepository
    @version  1.0.0
    @since 2022.05.02 - 18:47
*/

import edu.study.two.springlab.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
