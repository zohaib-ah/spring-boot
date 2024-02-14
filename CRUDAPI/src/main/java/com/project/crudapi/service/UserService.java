package com.project.crudapi.service;

import com.project.crudapi.entity.User;;import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    Void userDelete(Long id);
}
