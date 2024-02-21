package com.project.crudapiwithdto.mapper;

import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    UserDto JpaToDto(User user);
    User DtoToJpa (UserDto userDto);
}
