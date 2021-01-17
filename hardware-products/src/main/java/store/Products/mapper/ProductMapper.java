package store.Products.mapper;

import org.springframework.stereotype.Component;
import store.Products.dto.*;
import store.Products.entities.products.*;

@Component
public class ProductMapper {

    public Product updateProductDto(UpdateProductDto updateProductDto){
        return new Product(updateProductDto.getProductId(),0,null,updateProductDto.getProductPrice());
    }
}
