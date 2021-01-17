package store.Products.dto;

import store.Products.entities.products.GraphicCard;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GraphicCardProduct {


    @NotBlank(message = "product name cannot be null")
    private String productName;
    @NotBlank(message = "memory size cannot be null")
    private String memorySize;
    @NotBlank(message = "memory type cannot be null")
    private String memoryType;
    @NotBlank(message = "the interface cannot be null")
    private String interfacee;
    @NotNull(message = "price cannot be null")
    @Min(1)
    private double productPrice;

    public GraphicCardProduct(){}

    public GraphicCardProduct( String productName, String memorySize, String memoryType, String interfacee, double productPrice) {

        this.productName = productName;
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.interfacee = interfacee;
        this.productPrice = productPrice;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
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
