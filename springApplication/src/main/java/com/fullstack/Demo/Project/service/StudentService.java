package com.fullstack.Demo.Project.service;

import com.fullstack.Demo.Project.dto.StudentRequest;
import com.fullstack.Demo.Project.dto.StudentResponse;
import com.fullstack.Demo.Project.model.Student;
import com.fullstack.Demo.Project.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public void postStudent(StudentRequest studentRequest){
        Student student = Student.builder()
                        .name(studentRequest.getName())
                                .address(studentRequest.getAddress())
                                        .build();
        studentRepository.save(student);
        log.info("Student {} is saved",student.getId());
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::MaptoResponse).toList();
    }

    private StudentResponse MaptoResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .address(student.getAddress())
                .build();
    }
}
