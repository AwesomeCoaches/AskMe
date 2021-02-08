package com.coach.askme.repo;

import com.coach.askme.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepo extends MongoRepository<Person, String> {
}
