package com.project.task.mapper;

import com.project.task.dto.TaskDto;
import com.project.task.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TaskMapper {

    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    //JPA to DTO
    TaskDto jpaToDto(Task task);



    //DTO to JPA
    Task dtoToJpa(TaskDto taskDto);
}
