package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.ProductDto;
import store.Products.entities.products.Product;
import store.Products.querys.ProductQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static store.Products.querys.ProductQuerys.*;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductDto> getProducts(){
        return jdbcTemplate.query(ProductQuerys.GET_PRODUCTS_SQL,new BeanPropertyRowMapper<>(ProductDto.class));
    }

    public Product addNewProduct(Product product){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_PRODUCT_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,product.getCategoryId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getProductPrice());
            return preparedStatement;
        }, keyHolder);
        product.setProductId(keyHolder.getKey().intValue());
        return product;
    }
    

    public void updateProduct(Product product){
        jdbcTemplate.update(UPDATE_PRODUCT_SQL, product.getProductPrice(),product.getProductId());
    }

    public Optional<Product> getProductById(int productId) {
       String sql = "select * from product p where p.productId = ?";

        RowMapper<Product> mapper = (resultSet, rowNum) ->
                new Product(resultSet.getInt("productId"),
                        resultSet.getInt("categoryId"),
                        resultSet.getString("productName"),
                        resultSet.getDouble("productPrice"));
        List<Product> products = jdbcTemplate.query(sql, mapper, productId);
        if(products != null && !products.isEmpty()) {
            return Optional.of(products.get(0));
        } else {
            return Optional.empty();
        }
    }

}
