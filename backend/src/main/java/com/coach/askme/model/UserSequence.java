package com.coach.askme.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "userSequence")
public class UserSequence {

    @Id
    private String id;
    private Long seq;
}

