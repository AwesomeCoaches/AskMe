package com.coach.askme.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answer")
public class Answer {

//    private String _id; // 답글 아이디
    @Transient
    public static final String SEQUENCE_NAME = "answer_sequence";

    @Id
    private Long aid; // 답글 번호
    private String Content; // 답글 내용
    private String Author; // 답글 작성자

    @DBRef
    private Question question;

    private String CreateDate; // 답글 등록일


}
