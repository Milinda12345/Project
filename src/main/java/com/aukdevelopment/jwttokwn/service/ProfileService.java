package com.aukdevelopment.jwttokwn.service;

import com.aukdevelopment.jwttokwn.dto.ProfileDTO;
import com.aukdevelopment.jwttokwn.entity.ProfileEntity;
import com.aukdevelopment.jwttokwn.entity.UserEntity;
import com.aukdevelopment.jwttokwn.repository.ProfileRepository;
import com.aukdevelopment.jwttokwn.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public ProfileDTO getProfileByUser(String id) {

        ProfileEntity profile = profileRepository.findById(id).orElse (null);
        if (profile == null) return null;
        return new ProfileDTO(profile.getId(),profile.getImage(),profile.getStatus());
    }

    public ProfileDTO createProfile(String userID , ProfileDTO profileData){
        UserEntity user = userRepository.findById(userID).orElse (null);
        if (user == null) return null;
        ProfileEntity profile = new ProfileEntity(profileData.getImage() , profileData.getStatus());
        profile.setUser(user);

        ProfileEntity savedProfile = profileRepository.save(profile);

        user.setProfile(savedProfile);
        userRepository.save(user);

        return new ProfileDTO(savedProfile.getId(),savedProfile.getImage(),savedProfile.getStatus());
    }
}
