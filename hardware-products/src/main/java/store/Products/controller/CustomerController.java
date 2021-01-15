package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.CustomerRequest;
import store.Products.entities.customer.Customer;
import store.Products.mapper.CustomerMapper;
import store.Products.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/customer")
@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public List<CustomerRequest> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> addNewCustomer(
            @Valid
            @RequestBody CustomerRequest customerRequest){
        Customer customer= customerMapper.customerRequest(customerRequest);
        customerService.addNewCustomer(customer);
        return  ResponseEntity.created(null).build();
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(int id){
        customerService.deleteCustomer(id);
    }
}
