package com.example.sms.mapper;

import com.example.sms.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> findAll();

    Student findById(int id);

    void insert(Student student);

    void update(Student student);

    void delete(int id);
}
