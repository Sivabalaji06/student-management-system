package com.example.sms.controller;

import com.example.sms.model.Course;
import com.example.sms.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // 1️⃣ Assign course
    @PostMapping("/assign")
    public String assignCourse(
            @RequestParam int studentId,
            @RequestParam int courseId) {

        service.assignCourse(studentId, courseId);
        return "Course assigned successfully!";
    }

    // 2️⃣ Unassign course
    @DeleteMapping("/unassign")
    public String unassignCourse(
            @RequestParam int studentId,
            @RequestParam int courseId) {

        service.unassignCourse(studentId, courseId);
        return "Course unassigned successfully!";
    }

    // 🔥 3️⃣ GET COURSES FOR A STUDENT (THIS WAS MISSING / WRONG)
    @GetMapping("/student/{studentId}")
    public List<Course> getCoursesByStudent(@PathVariable int studentId) {
        return service.getCoursesByStudent(studentId);
    }
}
