package com.coach.askme.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Document
public class Question {

    private String _id; // 질문 아이디

//    @Generated
    private Integer qid; // 질문 번호
    private String Title; // 질문 제목
    private String Content; // 질문 내용
    private String Author; // 질문 작성자

//    private String[] tags; // 질문 태그

//    @DBRef
//    private Collection<Answer> Answer; // 질문 답글들

    @Field
    private Integer Count = 1; // 질문받은 횟수

    private String MainCategory; // 대분류
    private String SubCategory; // 소분류

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime CreateDate; // 질문 등록일


}
