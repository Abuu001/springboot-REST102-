package com.example.demo.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {

    @Id
    private int pid;
    private String productName;
    private  int quantity;
    private int price;

    public Product(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
