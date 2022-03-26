package com.centradatabase.consumerapp.repository;

import com.centradatabase.consumerapp.model.Container;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<Container,String> {
}
