package com.manyToMany.mapping.dao;

import com.manyToMany.mapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    public Student getStudentByEmail(String email);
}
