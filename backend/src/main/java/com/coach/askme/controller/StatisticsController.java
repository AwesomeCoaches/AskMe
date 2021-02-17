package com.coach.askme.controller;

import com.coach.askme.model.Question;
import com.coach.askme.repo.QuestionRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
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
        SortOperation sortA = Aggregation.sort(Sort.Direction.DESC, "Questions");
        LimitOperation limitA = Aggregation.limit(10);
        Aggregation aggregationA = Aggregation.newAggregation(groupA, sortA, limitA);
        AggregationResults<HashMap> resultA = mongoTemplate.aggregate(aggregationA, "question", HashMap.class);
        List<HashMap> listA = resultA.getMappedResults();

        GroupOperation groupB = Aggregation.group("Keyword").count().as("Questions");
        SortOperation sortB = Aggregation.sort(Sort.Direction.DESC, "Questions");
        LimitOperation limitB = Aggregation.limit(10);
        Aggregation aggregationB = Aggregation.newAggregation(groupB, sortB, limitB);
        AggregationResults<HashMap> resultB = mongoTemplate.aggregate(aggregationB, "question", HashMap.class);
        List<HashMap> listB = resultB.getMappedResults();

        HashMap<String, List> result = new HashMap<>();
        result.put("subCategory",listA);
        result.put("keyword",listB);

        return result;
    }
}
