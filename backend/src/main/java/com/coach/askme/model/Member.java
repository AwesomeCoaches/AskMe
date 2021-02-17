package com.coach.askme.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Member {

    @Transient
    public static final String SEQUENCE_NAME = "member_sequence";

    @Id
    private Long mid;
    private String name;
    private String password;
}
