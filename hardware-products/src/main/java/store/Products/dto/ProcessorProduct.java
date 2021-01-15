package store.Products.dto;

import javax.annotation.PreDestroy;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProcessorProduct {


    @NotBlank(message = "the category name cannot be null")
    private String categoryName;
    @NotBlank(message = "the product name cannot be null")
    private String productName;
    @NotBlank(message = "the core of the processor cannot be null")
    private String core;
    @NotBlank(message = "the frequency of the processor cannot be null")
    private String frequency;
    @NotBlank(message = "the socket of the processor cannot be null")
    private String socket;
    @NotBlank(message = "the series of the processor cannot be null")
    private String series;
    @NotBlank(message = "the manufacturing technology of the processor cannot be null")
    private String manufacturingTechnology;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public ProcessorProduct(){}

    public ProcessorProduct(String categoryName, String productName, String core, String frequency, String socket, String series, String manufacturingTechnology, double productPrice) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.core = core;
        this.frequency = frequency;
        this.socket = socket;
        this.series = series;
        this.manufacturingTechnology = manufacturingTechnology;
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

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getManufacturingTechnology() {
        return manufacturingTechnology;
    }

    public void setManufacturingTechnology(String manufacturingTechnology) {
        this.manufacturingTechnology = manufacturingTechnology;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
