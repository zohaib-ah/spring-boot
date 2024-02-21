package com.project.task.service.impl;

import com.project.task.dto.TaskDto;
import com.project.task.entity.Task;
import com.project.task.exception.TaskNotfoundException;
import com.project.task.mapper.TaskMapper;
import com.project.task.repository.TaskRepository;
import com.project.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TaskImplementation implements TaskService {


    private TaskRepository taskRepository;
    @Override
    public TaskDto addTask(TaskDto taskDto) {

        Task task = TaskMapper.MAPPER.dtoToJpa(taskDto);

        Task taskSaved =  taskRepository.save(task);

        TaskDto taskReturn = TaskMapper.MAPPER.jpaToDto(taskSaved);

        return taskReturn;
    }

    @Override
    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotfoundException("Task not found with the id" +id));
        return TaskMapper.MAPPER.jpaToDto(task);
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper.MAPPER::jpaToDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Long id) {

        Task task =  taskRepository.findById(id).orElseThrow(() -> new TaskNotfoundException("Task not found with id: " + id));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setComplete(taskDto.isComplete());

        Task update = taskRepository.save(task);

        return TaskMapper.MAPPER.jpaToDto(update);



    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new TaskNotfoundException("Task not found with id: " + id));

        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto taskComplete(Long id) {


        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotfoundException("Task not found with id: " + id));
        task.setComplete(Boolean.TRUE);
        Task task1 = taskRepository.save(task);

        return TaskMapper.MAPPER.jpaToDto(task1);
    }

    @Override
    public TaskDto taskInComplete(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotfoundException("Task not found with id: " + id));
        task.setComplete(Boolean.FALSE);
        Task task1 = taskRepository.save(task);

        return TaskMapper.MAPPER.jpaToDto(task1);
    }
}
