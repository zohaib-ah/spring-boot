package com.project.restapi.controller;


import com.project.restapi.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "Zohaib", "Ahmad");


//        will return response in JSON
        return student;
    }

//    @PathVariable extract values from URI templates and bind them to method parameters


//    http://localhost:8080/students/1/zohaib/ahmad
    @GetMapping("/students/{id}/{FirstName}/{LastName}")
    public Student StudentPathVariable(@PathVariable int id,
                                       @PathVariable String FirstName,
                                       @PathVariable String LastName){
        Student student = new Student(id , FirstName, LastName);

        return student;
    }

//    @RequestParam is used to extract query parameters from the URL and bind them to method parameters


//    http://localhost:8080/students/query?id=1&FirstName=zohaib&LastName=ahmad
    @GetMapping("/students/query")
    public Student studentRequestParam(@RequestParam int id,
                                       @RequestParam String FirstName,
                                       @RequestParam String LastName){
        Student student = new Student(id, FirstName, LastName);
        return student;
    }


    //Spring boot HTTP Post request

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


}

