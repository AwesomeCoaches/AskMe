package com.coach.askme.controller;


import com.coach.askme.model.Answer;
import com.coach.askme.repo.AnswerRepo;
import com.coach.askme.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "답글에 대한 API")
@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    AnswerService answerService;


    @ApiOperation(value = "답글 전체 리스트")
    @GetMapping("")
    public List<Answer> getQuestion() {
        List<Answer> list = answerRepo.findAll();
        return list;
    }

    @ApiOperation(value = "답글 상세정보")
    @GetMapping("/{aid}")
    public Answer getQuestion(@PathVariable Long aid) {
        Optional<Answer> aOpt =  answerRepo.findByAid(aid);
        return aOpt.get();
    }

    @ApiOperation(value = "답글 등록")
    @PostMapping("")
    public ResponseEntity<Boolean> insertQuestion(@RequestBody Answer answer) {
        // save
        answer.setAid(answerService.getNextSequence("answer_sequence"));
        answerRepo.save(answer);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "답글 수정")
    @PutMapping("")
    public ResponseEntity<Boolean> updateQuestion(@RequestBody Answer answer) {
        // save

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "답글 삭제")
    @DeleteMapping("/{aid}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable Integer aid) {

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }



}
