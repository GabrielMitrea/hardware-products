package store.Products.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MouseProduct {

    @NotBlank(message = "the category name cannot be null")
    private String categoryName;
    @NotBlank(message = "the product name cannot be null")
    private String productName;
    @NotBlank(message = "the type of the mouse cannot be null")
    private String mouseType;
    @NotBlank(message = "the resolution of the mouse cannot be null")
    private String maxResolution;
    @NotBlank(message = "the interface cannot be null")
    private String interfacee;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public MouseProduct(){}

    public MouseProduct(String categoryName,String productName, String mouseType, String maxResolution, String interfacee, double productPrice) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.mouseType = mouseType;
        this.maxResolution = maxResolution;
        this.interfacee = interfacee;
        this.productPrice=productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getInterfacee() {
        return interfacee;
    }

    public void setInterfacee(String interfacee) {
        this.interfacee = interfacee;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
