package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "index"; // Loads index.html from /resources/templates
    }

    @PostMapping
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // Loads students.html to show all data
    }
}