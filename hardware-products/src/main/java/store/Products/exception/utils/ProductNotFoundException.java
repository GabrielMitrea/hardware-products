package store.Products.exception.utils;

import store.Products.model.ProductCategory;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
