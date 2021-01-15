package store.Products.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.CustomerRequest;
import store.Products.entities.customer.Customer;
import store.Products.querys.CustomerQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.CustomerQuerys.ADD_CUSTOMER_SQL;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CustomerRequest> getCustomer(){
        return jdbcTemplate.query(CustomerQuerys.GET_CUSTOMER_SQL,new BeanPropertyRowMapper<>(CustomerRequest.class));
    }

    public Customer addNewCustomer(Customer customer){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_CUSTOMER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getCountry());
            preparedStatement.setString(6, customer.getAddress());
            return preparedStatement;
        }, keyHolder);
        customer.setCustomerId(keyHolder.getKey().intValue());

        return customer;

    }
    public void deleteCustomer(int id){
        jdbcTemplate.update(CustomerQuerys.DELETE_CUSTOMER_SQL,id);
    }

}
