package com.example.bookstoreapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    // POST endpoint to create a new customer by accepting a JSON request body
    @PostMapping("/json")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        // Here you would normally save the customer to a database
        System.out.println("Customer registered with JSON:");
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: " + customer.getPassword());
        return new ResponseEntity<>("Customer registered successfully with JSON!", HttpStatus.CREATED);
    }

    // POST endpoint to process form data for customer registrations
    @PostMapping("/form")
    public ResponseEntity<String> registerCustomer(@RequestParam("firstName") String firstName,
                                                   @RequestParam("lastName") String lastName,
                                                   @RequestParam("email") String email,
                                                   @RequestParam("password") String password) {
        // Here you would normally save the customer to a database
        System.out.println("Customer registered with form data:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        return new ResponseEntity<>("Customer registered successfully with form data!", HttpStatus.CREATED);
    }
}

