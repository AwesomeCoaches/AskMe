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

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Api(value = "답글에 대한 API")
@RestController
@CrossOrigin("*")
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    AnswerService answerService;


    @ApiOperation(value = "답글 전체 리스트")
    @GetMapping("")
    public List<Answer> getAnswer() {
        List<Answer> list = answerRepo.findAll();
        return list;
    }

    @ApiOperation(value = "질문에 대한 답글 리스트")
    @GetMapping("/{qid}")
    public List<Answer>  getQuestion(@PathVariable Long qid) {
        List<Answer> list = answerRepo.findByQid(qid);
        return list;
    }

    @ApiOperation(value = "답글 상세정보")
    @GetMapping("/{aid}")
    public Answer getAnswer(@PathVariable Long aid) {
        Optional<Answer> aOpt =  answerRepo.findByAid(aid);
        return aOpt.get();
    }

    @ApiOperation(value = "답글 등록")
    @PostMapping("")
    public ResponseEntity<Boolean> insertAnswer(@RequestBody Answer answer) {
        // save
        answer.setAid(answerService.getNextSequence("answer_sequence"));
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
        String time = format.format(System.currentTimeMillis());
        answer.setCreateDate(time);
        answerRepo.save(answer);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "답글 수정")
    @PutMapping("")
    public ResponseEntity<Boolean> updateAnswer(@RequestBody Answer answer) {
        // save
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
        String time = format.format(System.currentTimeMillis());
        answer.setCreateDate(time);
        answerRepo.save(answer);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @ApiOperation(value = "답글 삭제")
    @DeleteMapping("/{aid}")
    public ResponseEntity<Boolean> deleteAnswer(@PathVariable Long aid) {
        answerRepo.deleteById(aid);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }



}
