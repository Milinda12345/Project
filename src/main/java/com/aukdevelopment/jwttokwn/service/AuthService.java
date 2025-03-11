package com.aukdevelopment.jwttokwn.service;

import com.aukdevelopment.jwttokwn.dto.LoginRequestDTO;
import com.aukdevelopment.jwttokwn.dto.LoginResponseDTO;
import com.aukdevelopment.jwttokwn.dto.RegisterRequestDTO;
import com.aukdevelopment.jwttokwn.dto.RegisterResponseDTO;
import com.aukdevelopment.jwttokwn.entity.UserEntity;
import com.aukdevelopment.jwttokwn.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public UserEntity createUser(RegisterRequestDTO userData) {
        UserEntity newuser = new UserEntity(
                userData.getName(),
                userData.getId(),
                userData.getEmail(),
                userData.getUsername(),
                passwordEncoder.encode(userData.getPassword()));

        return userRepository.save(newuser);
    }
    public LoginResponseDTO login(LoginRequestDTO loginData){

      //  Boolean userPresent = isUserEnable(loginData.getUsername());
       // if (!userPresent) return new LoginResponseDTO(null, null , "User not found" , error);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword()));
        }catch (Exception e){
            return new LoginResponseDTO(null, null , "User not found" , "error");
        }

        Map<String, Object> claims = new HashMap<String,Object >();
        claims.put("role" , "User");
        claims.put("enail" , "company@gmail.com");

        String token = jwtService.getJWTToken(loginData.getUsername(), claims);
        System.out.println(jwtService.getFiledFromToken(token, "role"));

        return new LoginResponseDTO(token , LocalDateTime.now(),null,"tolken Generated Successfully") ;
    }

    public RegisterResponseDTO register(RegisterRequestDTO req){
        if (isUserEnable(req.getUsername())) return new RegisterResponseDTO(null , "User already exist in the system");
        var userData = this.createUser(req);
        if (userData.getId() == null) return new RegisterResponseDTO(null , "System Error");
        return new RegisterResponseDTO(String.format("user register at %s",userData.getId()), null);
    }

    private Boolean isUserEnable(String username){
        return userRepository.findByUsername(username).isPresent();
    }
}
