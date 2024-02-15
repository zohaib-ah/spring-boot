package com.project.crudapiwithdto.service;

import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;

import java.util.List;

;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    Void userDelete(Long id);
}
