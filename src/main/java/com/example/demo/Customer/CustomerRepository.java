package com.example.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

    @Query("SELECT new com.example.demo.Customer.OrderResponse(c.name,p.productName) FROM Customer c JOIN c.products p")
     List<OrderResponse> getJoinInformation();
}
