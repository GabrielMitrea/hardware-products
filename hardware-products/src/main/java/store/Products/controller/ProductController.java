package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.ProductDto;
import store.Products.dto.UpdateProductDto;
import store.Products.entities.products.Product;
import store.Products.mapper.ProductMapper;
import store.Products.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper){
        this.productService=productService;
        this.productMapper=productMapper;
    }

    @GetMapping
    public List<ProductDto> getProduct(){
        return productService.getProducts();
    }

    @PostMapping("/new")
    public ResponseEntity<Product> addNewProduct(
            @Valid
            @RequestBody Product product){
        productService.addNewProduct(product);
        return  ResponseEntity.created(null).build();
    }

    @PutMapping("/{productId}")
    public void updateProduct(
            @PathVariable
            int productId,
            @Valid
            @RequestBody
             UpdateProductDto updateProductDto){
        if(productId!=updateProductDto.getProductId()){
            throw new RuntimeException("Path variable doesn`t match the request body id.");
        }
        productService.updateProduct(productMapper.updateProductDto(updateProductDto));
    }
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }
    
}
