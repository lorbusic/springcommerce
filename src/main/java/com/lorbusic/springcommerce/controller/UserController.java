package com.lorbusic.springcommerce.controller;

import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.User;
import com.lorbusic.springcommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add",consumes = "application/json",produces = "application/json")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto newUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    @GetMapping(value = "/all",produces = "application/json")
    public ResponseEntity<List<User>> getAllUsersByIdSorted(){
        List<User> list = userService.getAllUsersByIdSorted();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/registration",produces = "application/json")
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }
}
