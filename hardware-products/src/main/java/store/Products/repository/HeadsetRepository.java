package store.Products.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger= LoggerFactory.getLogger(HeadsetRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<HeadsetProduct> getHeadsetProduct(){
        logger.info("Retrieving headsets....{}",jdbcTemplate.query(HeadsetQuerys.GET_HEADSET1_SQL,new BeanPropertyRowMapper<>(HeadsetProduct.class)));
        return jdbcTemplate.query(HeadsetQuerys.GET_HEADSET1_SQL,new BeanPropertyRowMapper<>(HeadsetProduct.class));
    }

    public List<Headset> addNewHeadset(Headset headset){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_HEADSET_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, headset.getHeadsetType());
            preparedStatement.setString(2, headset.getTechnology());
            preparedStatement.setString(3, headset.getSound());
            preparedStatement.setString(4, headset.getConectivity());
            preparedStatement.setInt(5, headset.getProductId());
            return preparedStatement;
        }, keyHolder);
        headset.setHeadsetId(keyHolder.getKey().intValue());
        logger.info("Adding new headset...{}",headset);
        return jdbcTemplate.query(HeadsetQuerys.GET_HEADSET1_SQL,new BeanPropertyRowMapper<>(Headset.class));

    }
    public void deleteHeadset(int id){
        jdbcTemplate.update(HeadsetQuerys.DELETE_HEADSET_SQL,id);

    }
}
