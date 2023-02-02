package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositories extends JpaRepository<Course, Long> {
}
