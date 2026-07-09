package com.kaviya.student_registration_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {

    return courseRepository.save(course);

}

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}