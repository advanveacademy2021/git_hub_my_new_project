package com.aacademy.firstrestproject.controller;

import com.aacademy.firstrestproject.model.User;
import com.aacademy.firstrestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;

    }//"localhost:8081/users"
    @GetMapping(value = "/users")
    public Set<User>findAll(){
        return userService.findAll();
    }

    //"localhost:8081/save/user"
    @GetMapping(value = "save/user")
    public ResponseEntity<User> save(@RequestBody  User user){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
    }
}
