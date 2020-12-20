package store.Products.entities.products;


import store.Products.entities.reviews.HeadsetReview;
import store.Products.entities.types.HeadsetType;
import store.Products.entities.types.ProductType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Headset {

    private long headsetId;
    @NotNull(message = "Category cannot be null")
    private ProductType category;
    @NotNull(message = "Type cannot be null")
    private HeadsetType type;
    @NotNull(message = "Model name cannot be null")
    private String modelName;
    @NotNull(message = "Technology cannot be null")
    private String technology;
    @NotNull(message = "Sound cannot be null")
    private String sound;
    @NotNull(message = "Connection cannot be null")
    private String connection;
    @NotNull(message = "Price cannot be null")
    @Min(1)
    private Double price;
    private List<HeadsetReview> headsetReview;

    public Headset(){}


    public Headset(long headsetId, ProductType category, HeadsetType type, String modelName, String technology, String sound, String connection, Double price, List<HeadsetReview> headsetReview) {
        this.headsetId=headsetId;
        this.category=category;
        this.type = type;
        this.modelName = modelName;
        this.technology = technology;
        this.sound = sound;
        this.connection = connection;
        this.price = price;
        this.headsetReview=headsetReview;
    }

    public long getHeadsetId() {
        return headsetId;
    }

    public void setHeadsetId(long headsetId) {
        this.headsetId = headsetId;
    }

    public ProductType getCategory() {
        return category;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public HeadsetType getType() {
        return type;
    }

    public void setType(HeadsetType type) {
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<HeadsetReview> getHeadsetReview() {
        return headsetReview;
    }

    public void setHeadsetReview(List<HeadsetReview> headsetReview) {
        this.headsetReview = headsetReview;
    }
}
