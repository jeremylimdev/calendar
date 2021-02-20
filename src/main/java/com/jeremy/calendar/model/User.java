package com.jeremy.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int id;

    private String username;
    private String password;
}
