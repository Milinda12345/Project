package com.aukdevelopment.jwttokwn.repository;

import com.aukdevelopment.jwttokwn.entity.ProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<ProfileEntity, String> {
    Optional<ProfileEntity> findByUsername(String username);
}
