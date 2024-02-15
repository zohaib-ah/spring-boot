package com.project.crudapiwithdto.mapper;

import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;

public class UserMapper {


    //Convert JPA user entity to DTO
    public static UserDto jpaToDto(User user){

        UserDto userDto = new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return userDto;
    }


    //Convert DTO to JPA user entity
    public  static User DtoToJpa(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }

}
