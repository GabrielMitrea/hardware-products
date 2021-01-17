package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.ShoppingCartRequest;
import store.Products.entities.shoppingCart.ShoppingCart;
import store.Products.querys.ShoppingCartQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.ShoppingCartQuerys.*;

@Repository
public class ShoppingCartRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ShoppingCart> getCart(){
        return jdbcTemplate.query(GET_ITEM_CART,new BeanPropertyRowMapper<>(ShoppingCart.class));
    }

    public List<ShoppingCartRequest> getCartItem(){
        return jdbcTemplate.query(GET_ITEM_CART1,new BeanPropertyRowMapper<>(ShoppingCartRequest.class));
    }

    public List<ShoppingCart> addItemInCart(ShoppingCart shoppingCart){
        KeyHolder keyHolder= new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement=connection.prepareStatement(ADD_ITEM_CART, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,shoppingCart.getProductId());
            preparedStatement.setInt(2,shoppingCart.getQuantity());
            preparedStatement.setDouble(3,shoppingCart.getTotalPrice());
            return  preparedStatement;
        }, keyHolder);
        shoppingCart.setCartId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(GET_ITEM_CART,new BeanPropertyRowMapper<>(ShoppingCart.class));
    }


}
