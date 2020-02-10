package com.example.parseserver.repositories;

import com.example.parseserver.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
