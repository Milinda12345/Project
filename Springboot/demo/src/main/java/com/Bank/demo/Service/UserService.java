package com.Bank.demo.Service;

import com.Bank.demo.Dto.UserDto;
import com.Bank.demo.Repositary.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getALluser(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDto>>(){}.getType());
    }

}
