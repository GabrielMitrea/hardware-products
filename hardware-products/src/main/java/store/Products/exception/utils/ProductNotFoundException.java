package store.Products.exception.utils;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
