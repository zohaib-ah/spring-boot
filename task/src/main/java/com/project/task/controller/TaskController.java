package com.project.task.controller;


import com.project.task.dto.TaskDto;
import com.project.task.entity.Task;
import com.project.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private TaskService taskService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){

        TaskDto taskDto1 =  taskService.addTask(taskDto);
        return new ResponseEntity<>(taskDto1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id){
        TaskDto taskDto = taskService.getTask(id);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> taskDtos = taskService.getAllTask();
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public  ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDto,@PathVariable Long id){
        TaskDto taskDto1 = taskService.updateTask(taskDto, id);

        return ResponseEntity.ok(taskDto1);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/complete")
public ResponseEntity<TaskDto> complete(@PathVariable Long id){
        TaskDto taskDto = taskService.taskComplete(id);
        return ResponseEntity.ok(taskDto);
}
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TaskDto> incomplete(@PathVariable Long id){
        TaskDto taskDto = taskService.taskInComplete(id);
        return ResponseEntity.ok(taskDto);
    }




}
