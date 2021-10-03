package com.manyToMany.mapping.service;

import com.manyToMany.mapping.dao.CourseRepository;
import com.manyToMany.mapping.dao.StudentRepository;
import com.manyToMany.mapping.entity.Course;
import com.manyToMany.mapping.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Override
    public List<Student> findAll() {
        return  studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {

        Optional<Student> foundStudent = studentRepository.findById(theId);
        Student student=null;
        if(foundStudent.isPresent()){
            student=foundStudent.get();
        }
        return student;
    }

    @Override
    public void save(Student theStudent) {
        List<Course> courses = theStudent.getCourses();
        for(Course c: courses) {

            courseRepository.save(c);
        }
        if(studentRepository.getStudentByEmail(theStudent.getEmail()) ==null)
            studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        List<Course> courses = studentRepository.findById(theId).get().getCourses();

        for(Course c: courses){
            courseRepository.deleteById(c.getId());
        }

        studentRepository.deleteById(theId);
    }
}
