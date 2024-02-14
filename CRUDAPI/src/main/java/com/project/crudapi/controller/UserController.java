package com.project.crudapi.controller;


import com.project.crudapi.service.UserService;
import lombok.AllArgsConstructor;
import com.project.crudapi.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/user")
public class UserController {

    private UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    //API CRUD CREATE OPERATION

//    http://localhost:8080/api/user
    @PostMapping
    public ResponseEntity<User> Create(@RequestBody User user){
        User saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    //API CRUD READ OPERATION
//    http://localhost:8080/api/user/1
@GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //API READ ALL OPERATION
    @GetMapping
    public  ResponseEntity<List<User>> getAll(){
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //API UPDATE OPERATION

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Long id ,@RequestBody User user){
       user.setId(id);
       User updatedUser =  userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //API DELETE OPERATION

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userService.userDelete(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }


}
