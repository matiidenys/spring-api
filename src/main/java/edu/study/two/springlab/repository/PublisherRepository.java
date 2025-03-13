package edu.study.two.springlab.repository;

/*
    @author  matiidenys
    @project  springlab
    @class  PublisherService
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import edu.study.two.springlab.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends MongoRepository<Publisher, String> {

}
