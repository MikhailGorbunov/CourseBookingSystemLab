package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class BookingController {

    @Autowired
    BookingRepositories bookingRepositories;

    @GetMapping(value = "/booking")
    public ResponseEntity<List<Booking>> findAllBookings()
    {
        return new ResponseEntity<>(bookingRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/booking/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepositories.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/booking")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking distillery){
        bookingRepositories.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

}
