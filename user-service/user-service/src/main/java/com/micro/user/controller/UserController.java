package com.micro.user.controller;

import com.micro.user.Vo.ResponseVoTemplate;
import com.micro.user.entity.UserEntity;
import com.micro.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger("UserController");

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity user){
        logger.info("Inside save user controller");
        logger.info("saving user--- {}", user.toString());
        return userService.saveUser(user);
    }


    @GetMapping("/user/{id}")
    public ResponseVoTemplate getUser(@PathVariable Long id){
        return userService.findUseDepartmentById(id);
    }
}
