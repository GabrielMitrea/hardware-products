package store.Products.model.products;

import store.Products.model.ProductCategory;
import store.Products.model.reviews.LaptopReview;
import store.Products.model.types.LaptopType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Laptop {

    private long id;

    @NotNull(message = "Category cannot be null")
    private ProductCategory category;
    @NotNull(message = "Model name cannot be null")
    private String model;

    @NotNull(message = "Type cannot be null")
    private LaptopType type;

    @NotNull(message = "CPU model cannot be null")
    private String cpuModel;

    @NotNull(message = "GPU model cannot be null")
    private String gpuModel;

    @NotNull(message = "Memory size cannot be null")
    private String memoryRamSize;

    @NotNull(message = "Storage capacity cannot be null")
    private String storageCapacity;

    @NotNull(message = "Price cannot be null")
    private Double price;
    private List<LaptopReview> laptopReviews;

    public Laptop(){}

    public Laptop(long id,ProductCategory category,String model, LaptopType type, String cpuModel, String gpuModel, String memoryRamSize,String storageCapacity,Double price, List<LaptopReview> laptopReviews) {
        this.id=id;
        this.category=category;
        this.model = model;
        this.type = type;
        this.cpuModel = cpuModel;
        this.gpuModel = gpuModel;
        this.memoryRamSize = memoryRamSize;
        this.storageCapacity = storageCapacity;
        this.price = price;
        this.laptopReviews = laptopReviews;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LaptopType getType() {
        return type;
    }

    public void setType(LaptopType type) {
        this.type = type;
    }

    public String getcpuModel() {
        return cpuModel;
    }

    public void setcpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getgpuModel() {
        return gpuModel;
    }

    public void setgpuModel(String gpuModel) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<LaptopReview> getlaptopReviews() {
        return laptopReviews;
    }

    public void setlaptopReviews(List<LaptopReview> laptopReviews) {
        this.laptopReviews = laptopReviews;
    }
}
