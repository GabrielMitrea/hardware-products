package store.Products.mapper;

import org.springframework.stereotype.Component;
import store.Products.dto.CustomerRequest;
import store.Products.entities.customer.Customer;

@Component
public class CustomerMapper {

    public Customer customerRequest(CustomerRequest customerRequest){
        return new Customer(customerRequest.getFirstName(),customerRequest.getLastName(),customerRequest.getEmail(),customerRequest.getPhoneNumber(),customerRequest.getCountry(),customerRequest.getAddress());
    }
}
