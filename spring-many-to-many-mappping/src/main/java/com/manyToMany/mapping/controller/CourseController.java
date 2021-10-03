package com.manyToMany.mapping.controller;

import com.manyToMany.mapping.entity.Course;
import com.manyToMany.mapping.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId){
        return courseService.findById(courseId);
    }

    @PutMapping("/courses/")
    public void updateCourse(@RequestBody Course course){
         courseService.save(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable int courseId){
        courseService.deleteById(courseId);
    }
}
