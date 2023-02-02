package com.codeclan.example.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "courseDate")
    private String courseDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = true)
    @JsonManagedReference
    private Course course;

    public Booking(String courseDate, Course course) {
        this.courseDate = courseDate;
        this.course = course;
    }


    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}