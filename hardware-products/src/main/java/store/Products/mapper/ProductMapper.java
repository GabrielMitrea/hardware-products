package store.Products.mapper;

import org.springframework.stereotype.Component;
import store.Products.dto.UpdateProductDto;
import store.Products.entities.products.Product;

@Component
public class ProductMapper {

    public Product updateProductDto(UpdateProductDto updateProductDto){
        return new Product(updateProductDto.getProductId(),null,updateProductDto.getProductPrice());
    }


}
