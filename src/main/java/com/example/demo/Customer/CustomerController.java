package com.example.demo.Customer;

  import lombok.AllArgsConstructor;
 import lombok.NoArgsConstructor;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerService.getInfo();
    }

    @PostMapping("/placeorder")
    public Customer placeOrder(@RequestBody Customer request){
        return customerService.placeOrder(request);
    }

    @GetMapping("/findallorders")
    public List<Customer> getAllOrders(){
        return customerService.getAllOrders();
    }
}
