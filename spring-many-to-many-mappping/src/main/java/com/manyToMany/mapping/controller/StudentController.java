package com.manyToMany.mapping.controller;

import com.manyToMany.mapping.entity.Student;
import com.manyToMany.mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return  studentService.findById(studentId);
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteById(@PathVariable int studentId){
        studentService.deleteById(studentId);
    }
}
