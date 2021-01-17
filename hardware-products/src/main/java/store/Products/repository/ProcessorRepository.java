package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.ProcessorProduct;
import store.Products.entities.products.Processor;
import store.Products.querys.ProcessorQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.ProcessorQuerys.ADD_PROCESSOR_SQL;


@Repository
public class ProcessorRepository {

 
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ProcessorProduct> getProcessorProduct(){
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR1_SQL,new BeanPropertyRowMapper<>(ProcessorProduct.class));
    }

    public List<Processor> addNewProcessor(Processor processor){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_PROCESSOR_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, processor.getCore());
            preparedStatement.setString(2, processor.getFrequency());
            preparedStatement.setString(3, processor.getSocket());
            preparedStatement.setString(4, processor.getSeries());
            preparedStatement.setString(5, processor.getManufacturingTechnology());
            preparedStatement.setInt(6,processor.getProductId());

            return preparedStatement;
        }, keyHolder);
        processor.setProcessorId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR1_SQL,new BeanPropertyRowMapper<>(Processor.class));

    }
    public void deleteProcessor(int id){
        jdbcTemplate.update(ProcessorQuerys.DELETE_PROCESSOR_SQL,id);
    }

}
