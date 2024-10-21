package com.example.Controller;

import com.example.Model.Product;
import com.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Autowired
    private DiscoveryClient discoveryClient;

    private final OrderServiceClient orderServiceClient;


    public ProductController(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }


//    // 1. Get all products
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        return ResponseEntity.ok(productService.getAllProducts());
//    }
//
//    // 2. Get a specific product by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        return ResponseEntity.ok(productService.getProductById(id));
//    }
//
//    // 3. Create a new product
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        Product createdProduct = productService.createProduct(product);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
//    }
//
//    // 4. Update an existing product
//    @PutMapping("/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
//        Product product = productService.updateProduct(id, updatedProduct);
//        return ResponseEntity.ok(product);
//    }
//
//    // 5. Delete a product by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }


    // 2. Get a specific product by ID
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {

        List<ServiceInstance> instances = discoveryClient.getInstances("order-service");
        if (!instances.isEmpty()) {
            // Get the URI of the first instance
            ServiceInstance instance = instances.get(0);
            String orderServiceUrl = instance.getUri().toString() + "/orders/" + id;
            System.out.println(instance.getUri().toString() );

            // Make a REST call to the order service using its service name
            return restTemplate.getForObject(orderServiceUrl, String.class);
        } else {
            return "Order service not available.";
        }
    }

    @GetMapping
    public String getProductById() {
        try {
            return orderServiceClient.getOrderById();
        } catch (Exception e) {
            return "Order service not available.";
        }
    }

    // 3. Create a new product
    @PostMapping
    public String createProduct(@RequestBody Product product) {
       return "POST PRODUCT";
    }


    // 4. Delete a product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
       return "DELETE PRODUCT";
    }
}
