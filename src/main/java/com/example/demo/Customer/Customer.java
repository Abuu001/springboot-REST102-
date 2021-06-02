package com.example.demo.Customer;

import com.example.demo.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;

    @Autowired
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "id")
    private List<Product> products;

    public Customer(String name, String email, String gender, List<Product> products) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.products = products;
    }

    public Customer(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
