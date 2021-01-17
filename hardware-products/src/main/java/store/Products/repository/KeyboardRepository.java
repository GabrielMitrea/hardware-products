package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.KeyboardProduct;
import store.Products.entities.products.Keyboard;
import store.Products.querys.KeyboardQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


import static store.Products.querys.KeyboardQuerys.ADD_KEYBOARD_SQL;


@Repository
public class KeyboardRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<KeyboardProduct> getKeyboardProduct(){
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD1_SQL,new BeanPropertyRowMapper<>(KeyboardProduct.class));
    }
    public List<Keyboard> addNewKeyboard(Keyboard keyboard){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_KEYBOARD_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, keyboard.getKeyboardType());
            preparedStatement.setString(2, keyboard.getIsLightened());
            preparedStatement.setString(3, keyboard.getIsMechanic());
            preparedStatement.setInt(4,keyboard.getProductId());
            return preparedStatement;
        }, keyHolder);
        keyboard.setProductId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD1_SQL,new BeanPropertyRowMapper<>(Keyboard.class));

    }
    public void deleteKeyboard(int id){
        jdbcTemplate.update(KeyboardQuerys.DELETE_KEYBOARD_SQL,id);
    }
}
