package com.aukdevelopment.jwttokwn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    
    private String id;
    private String name ;
    private String email ;
    @Indexed(unique = true)
    private String username;
    private String password;

    @DBRef
    private ProfileEntity profile;

    public UserEntity(String name, String id, String email, String username, String encode) {
    }
}

