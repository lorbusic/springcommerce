package com.lorbusic.springcommerce.service;

import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<User> getAllUsersByIdSorted();
}
