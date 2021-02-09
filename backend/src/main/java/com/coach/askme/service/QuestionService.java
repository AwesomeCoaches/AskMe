package com.coach.askme.service;

import com.coach.askme.model.QuestionSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class QuestionService {

    @Autowired
    private MongoOperations mongo;

    public Long getNextSequence(String seqName)
    {
        QuestionSequence qs = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                QuestionSequence.class);
        return !Objects.isNull(qs) ? qs.getSeq() : 1;
    }

}
