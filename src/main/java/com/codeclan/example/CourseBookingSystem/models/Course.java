package com.codeclan.example.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "town")
    private String town;
    @Column(name = "starRating")
    private int starRating;

    @JsonBackReference
    @OneToMany(mappedBy = "course")
    private List<Booking> bookings;

    @JsonBackReference
    @OneToMany(mappedBy = "course")
    private List<Course> course;

    public Course(String name, String town, int starRating) {
        this.name = name;
        this.bookings = new ArrayList<>();
        this.course = new ArrayList<>();
        this.town = town;
        this.starRating = starRating;
    }

    public Course(){}

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}



