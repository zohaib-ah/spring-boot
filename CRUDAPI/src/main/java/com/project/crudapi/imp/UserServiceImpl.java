package com.project.crudapi.imp;


import com.project.crudapi.repository.UserRepository;
import com.project.crudapi.service.UserService;
import lombok.AllArgsConstructor;
import com.project.crudapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> OptionalUser =  userRepository.findById(id);
        return OptionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exitinguser = userRepository.findById(user.getId()).get();
        exitinguser.setFirstName(user.getFirstName());
        exitinguser.setLastName(user.getLastName());
        exitinguser.setEmail(user.getEmail());

        User user1 = userRepository.save(exitinguser);
        return user1;


    }


    @Override
    public Void userDelete(Long id) {
        userRepository.deleteById(id);
        return null;
    }


}
