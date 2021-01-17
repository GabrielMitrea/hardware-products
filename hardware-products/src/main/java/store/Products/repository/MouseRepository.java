package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.MouseProduct;
import store.Products.entities.products.Mouse;
import store.Products.querys.MouseQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.MouseQuerys.ADD_MOUSE_SQL;

@Repository
public class MouseRepository {

    
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<MouseProduct> getMouseProduct(){
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE1_SQL,new BeanPropertyRowMapper<>(MouseProduct.class));
    }

    public List<Mouse> addNewMouse(Mouse mouse){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_MOUSE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mouse.getMouseType());
            preparedStatement.setString(2, mouse.getMaxResolution());
            preparedStatement.setString(3, mouse.getInterfacee());
           preparedStatement.setInt(4,mouse.getProductId());
            return preparedStatement;
        }, keyHolder);
        mouse.setMouseId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE1_SQL,new BeanPropertyRowMapper<>(Mouse.class));

    }
    public void deleteMouse(int id){
        jdbcTemplate.update(MouseQuerys.DELETE_MOUSE_SQL,id);

    }

    
}
