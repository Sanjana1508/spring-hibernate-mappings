package com.manyToMany.mapping.service;

import com.manyToMany.mapping.dao.CourseRepository;
import com.manyToMany.mapping.entity.Course;
import com.manyToMany.mapping.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> foundCourse = courseRepository.findById(theId);
        Course course=null;
        if(foundCourse.isPresent()){
            course=foundCourse.get();
        }
        return course;
    }

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }
}
