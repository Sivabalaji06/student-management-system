package com.example.sms.service.impl;

import com.example.sms.exception.ResourceNotFoundException;
import com.example.sms.mapper.StudentMapper;
import com.example.sms.model.Student;
import com.example.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper;

    public StudentServiceImpl(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Student> getAll() {
        return mapper.findAll();
    }

    @Override
    public Student getById(int id) {
        Student student = mapper.findById(id);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        return student;
    }

    @Override
    public Student create(Student student) {
        mapper.insert(student);   // ✅ FIXED
        return student;
    }

    @Override
    public Student update(int id, Student student) {
        Student existing = mapper.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        student.setId(id);
        mapper.update(student);
        return student;
    }

    @Override
    public void delete(int id) {
        Student existing = mapper.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        mapper.delete(id);
    }
}
