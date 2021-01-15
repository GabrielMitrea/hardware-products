package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.OrderDto;
import store.Products.entities.shoppingCart.Order;
import store.Products.querys.OrderQuerys;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.OrderQuerys.ADD_ORDER_SQL;


@Repository
public class OrderRepository {
    
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;
    
    public Order createOrder(Order order){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_ORDER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getCustomerId());
            preparedStatement.setInt(2,order.getProductId());
            preparedStatement.setLong(3, order.getOrderNumber());
            preparedStatement.setDate(4, order.getDateCreated());
            preparedStatement.setDate(5, order.getExpectedShipping());
            return preparedStatement;
        }, keyHolder);
        order.setOrderId(keyHolder.getKey().intValue());
        return order;
    }

    public List<OrderDto> getOrders(){
        return jdbcTemplate.query(OrderQuerys.GET_ORDER_SQL,new BeanPropertyRowMapper<>(OrderDto.class));
    }

    public void deleteOrder(int id){
    jdbcTemplate.update(OrderQuerys.DELETE_ORDER_SQL,id);
    }

}
