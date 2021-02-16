package com.coach.askme.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memberSequence")
public class MemberSequence {

    @Id
    private String id;
    private Long seq;
}

