package com.jeremy.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private String permissions;

    public User(String username, String password, boolean active, String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissions() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
