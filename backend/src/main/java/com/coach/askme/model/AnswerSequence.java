package com.coach.askme.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answerSequence")
public class AnswerSequence {

    /*
    답글 번호 auto increment 를 위한 model
    구현 내용은 AnswerService

     */

    @Id
    private String id;
    private Long seq;
}
