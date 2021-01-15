package store.Products.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class KeyboardProduct {

    @NotBlank(message = "category name cannot be null")
    private String categoryName;
    @NotBlank(message = "product name cannot be null")
    private String productName;
    @NotBlank(message = "the type of the keyboard cannot be null")
    private String keyboardType;
    @NotBlank(message = "is lightened property cannot be null")
    private String isLightened;
    @NotBlank(message = "is mechanic property cannot be null")
    private String isMechanic;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public KeyboardProduct(){}

    public KeyboardProduct(String categoryName, String productName, String keyboardType, String isLightened, String isMechanic, double productPrice) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.keyboardType = keyboardType;
        this.isLightened = isLightened;
        this.isMechanic = isMechanic;
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

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public String getIsLightened() {
        return isLightened;
    }

    public void setIsLightened(String isLightened) {
        this.isLightened = isLightened;
    }

    public String getIsMechanic() {
        return isMechanic;
    }

    public void setIsMechanic(String isMechanic) {
        this.isMechanic = isMechanic;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
