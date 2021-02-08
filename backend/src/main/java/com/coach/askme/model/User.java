package com.coach.askme.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    private String _id;
    private String name;
    private String password;
}
