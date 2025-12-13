package com.example.sms.service;

import com.example.sms.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(int id);
    Student create(Student student);
    Student update(int id, Student student);
    void delete(int id);
}
