package com.coach.askme.repo;

import com.coach.askme.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepo extends MongoRepository<Answer, String> {

    Optional<Answer> findByAid(Integer aid);
}
