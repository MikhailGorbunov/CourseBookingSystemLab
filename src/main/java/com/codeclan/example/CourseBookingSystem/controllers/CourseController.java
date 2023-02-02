package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CourseController {


    @Autowired
    CourseRepositories courseRepositories;

    @GetMapping(value = "/booking")
    public ResponseEntity<List<Course>> findAllCourses()
    {
        return new ResponseEntity<>(courseRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/booking/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepositories.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/booking")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepositories.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

}
