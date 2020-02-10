package com.example.parseserver.controlles;

import com.example.parseserver.entity.Course;
import com.example.parseserver.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    Iterable<Course> findAll(){
        return courseRepository.findAll();
    }

//    @DeleteMapping("/")
//    @PutMapping("/")
}
