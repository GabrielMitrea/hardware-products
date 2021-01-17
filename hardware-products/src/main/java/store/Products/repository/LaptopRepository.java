package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.LaptopProduct;
import store.Products.entities.products.Laptop;
import store.Products.querys.LaptopQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.LaptopQuerys.ADD_LAPTOP_SQL;


@Repository
public class LaptopRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<LaptopProduct> getLaptopProduct(){
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP1_SQL,new BeanPropertyRowMapper<>(LaptopProduct.class));
    }
    public List<Laptop> addNewLaptop(Laptop laptop){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_LAPTOP_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, laptop.getLaptopType());
            preparedStatement.setString(2, laptop.getCpuModel());
            preparedStatement.setString(3, laptop.getGpuModel());
            preparedStatement.setString(4, laptop.getMemoryRamSize());
            preparedStatement.setString(5, laptop.getStorageCapacity());
            preparedStatement.setInt(6,laptop.getProductId());
            return preparedStatement;
        }, keyHolder);
        laptop.setProductId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP1_SQL,new BeanPropertyRowMapper<>(Laptop.class));

    }
    public void deleteLaptop(int id){
        jdbcTemplate.update(LaptopQuerys.DELETE_LAPTOP_SQL,id);

    }
}
