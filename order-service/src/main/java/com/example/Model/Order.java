package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Order {
    @Id
    private Long id;
    private String productName;
    private int quantity;

    // Constructors, getters, and setters

    public Order() {

    }
    public Order(Long id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }



}

