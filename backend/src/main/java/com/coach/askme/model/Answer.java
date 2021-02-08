package com.coach.askme.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Document
public class Answer {

    private String _id; // 답글 아이디

//    @Generated
    private Integer aid; // 답글 번호
    private String Content; // 답글 내용
    private String Author; // 답글 작성자
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime CreateDate; // 답글 등록일


}
