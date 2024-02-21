package com.project.crudapiwithdto.controller;


import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;
import com.project.crudapiwithdto.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserDto> Create(@Valid @RequestBody UserDto user){
        UserDto saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    //API CRUD READ OPERATION
//    http://localhost:8080/api/user/1
@GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //API READ ALL OPERATION
    @GetMapping
    public  ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //API UPDATE OPERATION

    @PutMapping("{id}")
    public ResponseEntity<UserDto> update(@Valid  @PathVariable Long id , @RequestBody UserDto user){
       user.setId(id);
       UserDto updatedUser =  userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //API DELETE OPERATION

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userService.userDelete(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }


}
