package com.centradatabase.consumerapp.repository;

import com.centradatabase.consumerapp.model.Container;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends MongoRepository<Container, String> {
}
