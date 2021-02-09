package com.coach.askme.controller;


import com.coach.askme.model.Question;
import com.coach.askme.repo.QuestionRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "게시글에 대한 API")
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionRepo questionRepo;


    @ApiOperation(value = "질문 전체 리스트")
    @GetMapping("")
    public List<Question> getQuestion() {
        List<Question> list = questionRepo.findAll();
        return list;
    }

    @ApiOperation(value = "질문 상세정보")
    @GetMapping("/{qid}")
    public Question getQuestion(@PathVariable Long qid) {
        Optional<Question> qOpt =  questionRepo.findByQid(qid);
        return qOpt.get();
    }

    @ApiOperation(value = "질문 등록")
    @PostMapping("")
    public ResponseEntity<Boolean> insertQuestion(@RequestBody Question question) {
        // save

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "질문 수정")
    @PutMapping("")
    public ResponseEntity<Boolean> updateQuestion(@RequestBody Question question) {
        // save

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "질문 삭제")
    @DeleteMapping("/{qid}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable Integer qid) {

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }



}
