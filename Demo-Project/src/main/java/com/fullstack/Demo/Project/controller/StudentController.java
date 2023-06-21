package com.fullstack.Demo.Project.controller;

import com.fullstack.Demo.Project.dto.StudentRequest;
import com.fullstack.Demo.Project.dto.StudentResponse;
import com.fullstack.Demo.Project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String postStudent(@RequestBody StudentRequest studentRequest){
        studentService.postStudent(studentRequest);
        return "Student is created";
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

}
