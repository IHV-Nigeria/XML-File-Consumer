package com.centradatabase.consumerapp.repository;

import com.centradatabase.consumerapp.model.Tracker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackerRepository extends MongoRepository<Tracker, String> {
}
