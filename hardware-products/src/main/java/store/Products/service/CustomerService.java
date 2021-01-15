package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.CustomerRequest;
import store.Products.entities.customer.Customer;
import store.Products.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerRequest> getCustomer(){
        return customerRepository.getCustomer();
    }

    public Customer addNewCustomer(Customer customer){
       return customerRepository.addNewCustomer(customer);
    }

    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);
    }

}
