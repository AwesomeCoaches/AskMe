package com.coach.askme.repo;

import com.coach.askme.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepo extends MongoRepository<Answer, Long> {

    Optional<Answer> findByAid(Long aid);
    List<Answer> findByQid(Long qid);
}
