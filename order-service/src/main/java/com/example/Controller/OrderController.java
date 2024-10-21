package com.example.Controller;

import com.example.Model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping()
    public String viewOrder() {
        // Logic to retrieve an order by ID (e.g., fetching order from database)
//        Order order = new Order(id, "Product Name", 2); // Sample data
//        return new ResponseEntity<>(order, HttpStatus.OK);
        return "Get Order From feign Client";
    }
    // Create a new order
    @PostMapping
    public String createOrder(@RequestBody Order order) {
        // Logic to create an order (e.g., saving order to database)
//        return new ResponseEntity<>("Order created successfully!", HttpStatus.CREATED);
        return "Order created";
    }

    // View an order by ID
    @GetMapping("/{id}")
    public String viewOrder(@PathVariable Long id) {
        // Logic to retrieve an order by ID (e.g., fetching order from database)
//        Order order = new Order(id, "Product Name", 2); // Sample data
//        return new ResponseEntity<>(order, HttpStatus.OK);
        return "Get Order from RestTemplate";
    }

    // Cancel an order by ID
    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        // Logic to cancel an order (e.g., updating the order status in the database)
        return "Order cancelled";
    }
}
