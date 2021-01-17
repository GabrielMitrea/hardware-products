package store.Products.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @NotBlank(message = "category name cannot be null")
    private String categoryName;
    @NotBlank(message = "the name of the product cannot be null")
    private String productName;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public ProductDto(){}

    public ProductDto(String categoryName,String productName, double productPrice) {
        this.categoryName=categoryName;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
