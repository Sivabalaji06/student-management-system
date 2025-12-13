package com.example.sms.service.impl;

import com.example.sms.exception.ResourceNotFoundException;
import com.example.sms.mapper.CourseMapper;
import com.example.sms.mapper.StudentMapper;
import com.example.sms.model.Course;
import com.example.sms.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    public CourseServiceImpl(CourseMapper courseMapper,
                             StudentMapper studentMapper) {
        this.courseMapper = courseMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public void assignCourse(int studentId, int courseId) {
        if (studentMapper.findById(studentId) == null) {
            throw new ResourceNotFoundException("Student not found with id " + studentId);
        }
        if (courseMapper.findById(courseId) == null) {
            throw new ResourceNotFoundException("Course not found with id " + courseId);
        }
        courseMapper.assignCourse(studentId, courseId);
    }

    @Override
    public void unassignCourse(int studentId, int courseId) {
        courseMapper.unassignCourse(studentId, courseId);
    }

    @Override
    public List<Course> getCoursesByStudent(int studentId) {
        return courseMapper.findCoursesByStudent(studentId);
    }

    @Override
    public Course create(Course course) {
        courseMapper.insert(course);
        return course;
    }

    @Override
    public List<Course> getAll() {
        return courseMapper.findAll();
    }
}
