package com.project.task.service;

import com.project.task.dto.TaskDto;
import com.project.task.mapper.TaskMapper;

import java.util.List;

public interface TaskService{

    TaskDto addTask(TaskDto taskDto);

    TaskDto getTask(Long id);

    List<TaskDto> getAllTask();


    TaskDto updateTask(TaskDto taskDto, Long id);

    void deleteTask(Long id);

    TaskDto taskComplete(Long id);

    TaskDto taskInComplete(Long id);

}
