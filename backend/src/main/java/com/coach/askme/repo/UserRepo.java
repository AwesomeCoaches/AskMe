package com.coach.askme.repo;

import com.coach.askme.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepo extends MongoRepository<User, Long> {
    Optional<User> findByUid(Long uid);
    Optional<User> findByName(String name);
}
