package com.aukdevelopment.jwttokwn.controler;

import com.aukdevelopment.jwttokwn.dto.LoginRequestDTO;
import com.aukdevelopment.jwttokwn.dto.LoginResponseDTO;
import com.aukdevelopment.jwttokwn.dto.RegisterRequestDTO;
import com.aukdevelopment.jwttokwn.dto.RegisterResponseDTO;
import com.aukdevelopment.jwttokwn.entity.UserEntity;
import com.aukdevelopment.jwttokwn.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthControler {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    public AuthControler(AuthService authService, PasswordEncoder passwordEncoder) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<UserEntity> getAllUser() {
        return authService.getAllUser();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody RegisterRequestDTO user) {
        return authService.createUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginData) {

       LoginResponseDTO res = authService.login(loginData);
       if (res.getError() != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
       return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> login(@RequestBody RegisterRequestDTO req) {

        RegisterResponseDTO res = authService.register(req);
        if (res.getError() != null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
