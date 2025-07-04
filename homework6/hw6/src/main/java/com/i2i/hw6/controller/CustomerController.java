package com.i2i.hw6.controller;

import com.i2i.hw6.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Map<Integer, Customer> customerMap = new HashMap<>();
    private int currentId = 1;

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customer.setId(currentId++);
        customerMap.put(customer.getId(), customer);
        return ResponseEntity.ok(customer);
    }

    // Retrieve a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customerMap.get(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Retrieve all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(new ArrayList<>(customerMap.values()));
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerMap.get(id);
        if (existingCustomer != null) {
            updatedCustomer.setId(id);
            customerMap.put(id, updatedCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        if (customerMap.containsKey(id)) {
            customerMap.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
