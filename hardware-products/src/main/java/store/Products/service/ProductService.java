package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.ProductDto;
import store.Products.entities.products.Product;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProducts(){
        return productRepository.getProducts();
    }

    public Product addNewProduct(Product product){
        return productRepository.addNewProduct(product);
    }

    public Product getProduct(int productId) {
        Optional<Product> productOptional = productRepository.getProduct(productId);
        if(productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new ProductNotFoundException("Product with id: " + productId + " not found");
        }
    }

    public void updateProduct(Product product){
        productRepository.updateProduct(product);
    }

}
