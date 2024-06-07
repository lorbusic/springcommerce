package com.lorbusic.springcommerce.service.impl;

import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.mapper.UserMapper;
import com.lorbusic.springcommerce.model.User;
import com.lorbusic.springcommerce.repository.UserRepository;
import com.lorbusic.springcommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto){

        String psw=userDto.getUserPsd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        userDto.setUserPsd(passwordEncoder.encode(psw));

        User user = UserMapper.toEntity(userDto);
        User saveUser = userRepository.save(user);
        return UserMapper.toDto(saveUser);
    }

    @Override
    public List<User> getAllUsersByIdSorted() {
        return new ArrayList<User>(userRepository.getAllUsersByIdSorted());
    }

}
