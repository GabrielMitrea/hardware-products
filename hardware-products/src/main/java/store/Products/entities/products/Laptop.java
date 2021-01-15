package store.Products.entities.products;


import javax.validation.constraints.NotNull;
import java.util.List;

public class Laptop {

    private int LaptopId;

    @NotNull(message = "Category cannot be null")
    private String categoryName;


    @NotNull(message = "Type cannot be null")
    private String laptopType;

    @NotNull(message = "CPU model cannot be null")
    private String cpuModel;

    @NotNull(message = "GPU model cannot be null")
    private String gpuModel;

    @NotNull(message = "Memory size cannot be null")
    private String memoryRamSize;

    @NotNull(message = "Storage capacity cannot be null")
    private String storageCapacity;
    private int productId;




    public Laptop(){}

    public Laptop(int laptopId,  String categoryName,  String laptopType,  String cpuModel, String gpuModel,  String memoryRamSize,  String storageCapacity,int productId) {
        LaptopId = laptopId;
        this.categoryName = categoryName;
        this.laptopType = laptopType;
        this.cpuModel = cpuModel;
        this.gpuModel = gpuModel;
        this.memoryRamSize = memoryRamSize;
        this.storageCapacity = storageCapacity;
        this.productId=productId;
    }

    public int getLaptopId() {
        return LaptopId;
    }

    public void setLaptopId(int laptopId) {
        LaptopId = laptopId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
