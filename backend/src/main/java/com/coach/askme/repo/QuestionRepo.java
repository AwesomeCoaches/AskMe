package com.coach.askme.repo;

import com.coach.askme.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepo extends MongoRepository<Question, Long> {

    Optional<Question> findByQid(Long qid);
    List<Question> findByOrderByQidDesc();

}
