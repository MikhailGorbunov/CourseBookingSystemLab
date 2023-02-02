package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.CourseBookingSystemApplication;
import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepositories;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepositories;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner{
    @Autowired
    BookingRepositories bookingRepositories;
    @Autowired
    CourseRepositories courseRepositories;
    @Autowired
    CustomerRepositories customerRepositories;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Software development", "Edinburgh", 5);
        Booking booking1 = new Booking("3/02/2022", course1);
        Course course2 = new Course("Data Analysis", "Edinburgh", 0);
        Booking booking2 = new Booking("7/02/2022", course2);
        Customer customer1 = new Customer("Misha", "Edinburgh", 25);
        Customer customer2 = new Customer("Mar", "Edinburgh", 27);
        bookingRepositories.save(booking1);
        bookingRepositories.save(booking2);
        courseRepositories.save(course1);
        courseRepositories.save(course2);
        customerRepositories.save(customer1);
        customerRepositories.save(customer2);



    }

}
