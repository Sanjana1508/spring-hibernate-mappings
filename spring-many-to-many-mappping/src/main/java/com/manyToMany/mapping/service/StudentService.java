package com.manyToMany.mapping.service;

import com.manyToMany.mapping.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int theId);

    public void save(Student theStudent);

    public void deleteById(int theId);

}
