package store.Products.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LaptopProduct {

    @NotBlank(message = "the category name cannot be null")
    private String categoryName;
    @NotBlank(message = "the name of the product cannot be null")
    private String productName;
    @NotBlank(message = "the type of the laptop cannot be null")
    private String laptopType;
    @NotBlank(message = "the model of the cpu cannot be null")
    private String cpuModel;
    @NotBlank(message = "the model of the gpu cannot be null")
    private String gpuModel;
    @NotBlank(message = "the size of the memory ram cannot be null")
    private String memoryRamSize;
    @NotBlank(message = "capacity storage cannot be null")
    private String storageCapacity;
    @NotNull(message = "product name cannot be null")
    @Min((1))
    private double productPrice;

    public LaptopProduct(){}

    public LaptopProduct(String categoryName, String productName, String laptopType, String cpuModel, String gpuModel, String memoryRamSize, String storageCapacity, double productPrice) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.laptopType = laptopType;
        this.cpuModel = cpuModel;
        this.gpuModel = gpuModel;
        this.memoryRamSize = memoryRamSize;
        this.storageCapacity = storageCapacity;
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

    public String getLaptopType() {
        return laptopType;
    }

    public void setLaptopType(String laptopType) {
        this.laptopType = laptopType;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getMemoryRamSize() {
        return memoryRamSize;
    }

    public void setMemoryRamSize(String memoryRamSize) {
        this.memoryRamSize = memoryRamSize;
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
