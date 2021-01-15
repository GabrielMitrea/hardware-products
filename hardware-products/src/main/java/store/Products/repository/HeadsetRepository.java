package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.HeadsetProduct;
import store.Products.entities.products.Headset;
import store.Products.querys.HeadsetQuerys;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


import static store.Products.querys.HeadsetQuerys.ADD_HEADSET_SQL;


@Repository
public class HeadsetRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Headset> getHeadset(){
        return jdbcTemplate.query(HeadsetQuerys.GET_HEADSET_SQL,new BeanPropertyRowMapper<>(Headset.class));
    }

    public List<HeadsetProduct> getHeadsetProduct(){
        return jdbcTemplate.query(HeadsetQuerys.GET_HEADSET1_SQL,new BeanPropertyRowMapper<>(HeadsetProduct.class));
    }

    public List<Headset> addNewHeadset(Headset headset){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_HEADSET_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, headset.getCategoryName());
            preparedStatement.setString(2, headset.getHeadsetType());
            preparedStatement.setString(3, headset.getTechnology());
            preparedStatement.setString(4, headset.getSound());
            preparedStatement.setString(5, headset.getConectivity());
            preparedStatement.setInt(6, headset.getProductId());
            return preparedStatement;
        }, keyHolder);
        headset.setHeadsetId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(HeadsetQuerys.GET_HEADSET_SQL,new BeanPropertyRowMapper<>(Headset.class));

    }
    public void deleteHeadset(int id){
        jdbcTemplate.update(HeadsetQuerys.DELETE_HEADSET_SQL,id);

    }
}
