package com.example.sms.service;

import com.example.sms.model.Course;
import java.util.List;

public interface CourseService {

    Course create(Course course);

    List<Course> getAll();

    void assignCourse(int studentId, int courseId);

    void unassignCourse(int studentId, int courseId);

    List<Course> getCoursesByStudent(int studentId);
}
