package com.aukdevelopment.jwttokwn.controler;

import com.aukdevelopment.jwttokwn.dto.RegisterRequestDTO;
import com.aukdevelopment.jwttokwn.entity.UserEntity;
import com.aukdevelopment.jwttokwn.service.AuthService;
import com.aukdevelopment.jwttokwn.service.JWTService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeControler {

    private final JWTService jwtService;
    private final AuthService authService;

    public HomeControler(JWTService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @GetMapping
    public String gethello() {
        return "Welcome to the home page";
    }
    @PostMapping("/login")
    public String login() {
        return null ;
    }
    @GetMapping("/username")
    public String getUsername(@RequestParam String token) {
        return jwtService.getUsername(token);
    }
    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody RegisterRequestDTO user) {
        return authService.createUser(user);
    }
}
