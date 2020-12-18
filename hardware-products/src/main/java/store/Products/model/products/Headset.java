package store.Products.model.products;

import store.Products.model.ProductCategory;
import store.Products.model.reviews.HeadsetReview;
import store.Products.model.types.HeadsetType;

import java.util.List;

public class Headset {

    private Long id;
    private ProductCategory category;
    private HeadsetType type;
    private String modelName;
    private String technology;
    private String sound;
    private String connection;
    private Double price;
    private List<HeadsetReview> headsetReview;

    public Headset(){}


    public Headset(long id,ProductCategory category, HeadsetType type, String modelName, String technology, String sound, String connection, Double price,List<HeadsetReview> headsetReview) {
        this.id=id;
        this.category=category;
        this.type = type;
        this.modelName = modelName;
        this.technology = technology;
        this.sound = sound;
        this.connection = connection;
        this.price = price;
        this.headsetReview=headsetReview;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
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
