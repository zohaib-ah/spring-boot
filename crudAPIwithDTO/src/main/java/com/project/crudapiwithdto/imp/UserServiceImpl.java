package com.project.crudapiwithdto.imp;


import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;
import com.project.crudapiwithdto.exception.EmailExitException;
import com.project.crudapiwithdto.exception.UserNotFoundException;
import com.project.crudapiwithdto.mapper.AutoMapper;
import com.project.crudapiwithdto.mapper.UserMapper;
import com.project.crudapiwithdto.repository.UserRepository;
import com.project.crudapiwithdto.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {

//        User user1 = UserMapper.DtoToJpa(userDto);

        Optional<User> Optionaluser = userRepository.findByEmail(userDto.getEmail());

        if(Optionaluser.isPresent()){
            throw new EmailExitException("Email already exits for a user");

        }

        User user1 = AutoMapper.MAPPER.DtoToJpa(userDto);
        User saveduser = userRepository.save(user1);

//        UserDto savedDto = UserMapper.jpaToDto(saveduser);

        UserDto savedDto = AutoMapper.MAPPER.JpaToDto(saveduser);
        return savedDto;

    }

    @Override
    public UserDto getUserById(Long id) {

        User user =  userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user" , "id" , id)
        );

        //return UserMapper.jpaToDto(user);
        return AutoMapper.MAPPER.JpaToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(user -> AutoMapper.MAPPER.JpaToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User exitinguser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new UserNotFoundException("User", "id", user.getId())
        );
        exitinguser.setFirstName(user.getFirstName());
        exitinguser.setLastName(user.getLastName());
        exitinguser.setEmail(user.getEmail());

        User user1 = userRepository.save(exitinguser);

        //UserDto userDto = UserMapper.jpaToDto(user1);
        UserDto userDto = AutoMapper.MAPPER.JpaToDto(user1);

        return userDto;


    }

    @Override
    public Void userDelete(Long id) {
        User exitinguser = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);
        return null;
    }


}
