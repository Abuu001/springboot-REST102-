package com.example.demo.Customer;

import com.example.demo.Product.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Customer placeOrder(Customer request) {
        return customerRepository.save(request);
    }

    public List<Customer> getAllOrders() {
        return customerRepository.findAll();
    }

    public List<OrderResponse> getInfo() {
        return  customerRepository.getJoinInformation();
    }

}
