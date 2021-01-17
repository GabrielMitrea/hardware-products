package store.Products.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.GraphicCardProduct;
import store.Products.entities.products.GraphicCard;
import store.Products.querys.GraphicQuerys;



import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.GraphicQuerys.ADD_GRAPHICCARD_SQL;


@Repository
public class GraphicCardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger= LoggerFactory.getLogger(GraphicCardRepository.class);

    public List<GraphicCardProduct> getGraphicCardProduct(){
        logger.info("Retrieving graphic cards...{}", jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD1_SQL,new BeanPropertyRowMapper<>(GraphicCardProduct.class)));
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD1_SQL,new BeanPropertyRowMapper<>(GraphicCardProduct.class));
    }
    public List<GraphicCard> addNewGraphicCard(GraphicCard graphicCard){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_GRAPHICCARD_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, graphicCard.getMemorySize());
            preparedStatement.setString(2, graphicCard.getMemoryType());
            preparedStatement.setString(3, graphicCard.getInterfacee());
            preparedStatement.setInt(4, graphicCard.getProductId());
            return preparedStatement;
        }, keyHolder);
        graphicCard.setGraphicCardId(keyHolder.getKey().intValue());
        logger.info("Adding new headset...{}",jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD1_SQL,new BeanPropertyRowMapper<>(GraphicCard.class)));
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD1_SQL,new BeanPropertyRowMapper<>(GraphicCard.class));

    }

    public void deleteGraphicCard(int id){
        jdbcTemplate.update(GraphicQuerys.DELETE_GRAPHICCARD_SQL,id);

    }
}
