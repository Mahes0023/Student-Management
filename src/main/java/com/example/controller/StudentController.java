package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents()
    {
        System.out.println("getAllStudents() called");
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        return service.getStudentsById(id).orElse(null);
    }

    @PostMapping
    public Student createStudent(@RequestBody @Valid Student student)
    {
        return service.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id)
    {
        service.deleteStudent(id);
    }
}
