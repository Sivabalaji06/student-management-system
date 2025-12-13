package com.example.sms.mapper;

import com.example.sms.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {

    void insert(Course course);

    Course findById(int id);

    List<Course> findAll();

    void assignCourse(@Param("studentId") int studentId,
                      @Param("courseId") int courseId);

    void unassignCourse(@Param("studentId") int studentId,
                        @Param("courseId") int courseId);

    List<Course> findCoursesByStudent(int studentId);
}
