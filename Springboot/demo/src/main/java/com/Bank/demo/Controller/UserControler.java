package com.Bank.demo.Controller;

import com.Bank.demo.Dto.UserDto;
import com.Bank.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")
public class UserControler {
    @Autowired
    private UserService userService;

@GetMapping("/getuser")
    public List<UserDto> getUser() {
    return userService.getALluser();
}
}
