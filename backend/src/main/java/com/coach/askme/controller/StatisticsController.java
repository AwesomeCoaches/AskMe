package com.coach.askme.controller;

import com.coach.askme.model.Question;
import com.coach.askme.repo.QuestionRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "통계 대한 API")
@RestController
@CrossOrigin("*")
@RequestMapping("/statistics")
public class StatisticsController {

//    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    QuestionRepo questionRepo;

    @ApiOperation(value = "통계")
    @GetMapping("")
    public List<Question> getStatistics() {

        GroupOperation group = Aggregation.group("Count").count().as("Questions");
        Aggregation aggregation = Aggregation.newAggregation(group);

//        mongoTemplate = new MongoTemplate();
        AggregationResults results = mongoTemplate.aggregate(aggregation, "question", Question.class);

        List<Question> list = results.getMappedResults();

        list.forEach(System.out::println);

        return list;
    }
}
