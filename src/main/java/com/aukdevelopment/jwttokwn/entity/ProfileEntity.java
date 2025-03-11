package com.aukdevelopment.jwttokwn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {

    @Id
    private String id;
    private String image;
    private Boolean status;

    @DBRef
    private UserEntity user;

    public ProfileEntity(String image, Boolean status) {
        this.image = image;
        this.status = status;
    }
}
