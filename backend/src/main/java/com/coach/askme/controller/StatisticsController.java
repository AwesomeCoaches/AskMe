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
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public HashMap<String,List> getStatistics() {

        GroupOperation groupA = Aggregation.group("SubCategory").count().as("Questions");
        Aggregation aggregationA = Aggregation.newAggregation(groupA);
        AggregationResults<HashMap> resultA = mongoTemplate.aggregate(aggregationA, "question", HashMap.class);
        List<HashMap> listA = resultA.getMappedResults();

        GroupOperation groupB = Aggregation.group("Keyword").count().as("Questions");
        Aggregation aggregationB = Aggregation.newAggregation(groupB);
        AggregationResults<HashMap> resultB = mongoTemplate.aggregate(aggregationB, "question", HashMap.class);
        List<HashMap> listB = resultB.getMappedResults();

        HashMap<String, List> result = new HashMap<>();
        result.put("subCategory",listA);
        result.put("keyword",listB);

        return result;
    }
}
