package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CustomerController {

    @Autowired
    CustomerRepositories customerRepositories;

    @GetMapping(value = "/customer")
    public ResponseEntity<List<Customer>> findAllCustomers()
    {
        return new ResponseEntity<>(customerRepositories.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/customer/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepositories.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepositories.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
