package com.jeremy.calendarApp.model;

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
    private Boolean active;
    private String roles;

    public User(int sequenceNumber, String username, String password, boolean active, String roles) {
        this.id = sequenceNumber;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}
