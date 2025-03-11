package com.aukdevelopment.jwttokwn.controler;

import com.aukdevelopment.jwttokwn.dto.ProfileDTO;
import com.aukdevelopment.jwttokwn.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/profile")

public class ProfileControler {

    private final ProfileService profileService;

    public ProfileControler(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable String userId) {
        ProfileDTO profile = profileService.getProfileByUser(userId);
        if (profile == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid user id"));
        }
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/Create/{userId}")
    public  ResponseEntity<?> createProfile(@PathVariable String userId , @RequestBody ProfileDTO profileData) {
        ProfileDTO profile = profileService.createProfile(userId, profileData);
        if (profile == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid user id"));
        return ResponseEntity.ok(profile);
    }

}
