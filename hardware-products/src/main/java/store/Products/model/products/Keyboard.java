package store.Products.model.products;

import store.Products.model.ProductCategory;
import store.Products.model.reviews.KeyboardReview;
import store.Products.model.types.KeyboardType;

import java.util.List;

public class Keyboard {

    private long id;
    private ProductCategory category;
    private String modelName;
    private KeyboardType type;
    private String isLightened;
    private String isMechanic;
    private Double price;
    private List<KeyboardReview> keyboardReview;

    public Keyboard(){}

    public Keyboard(long id, ProductCategory category,String modelName, KeyboardType type, String isLightened,String isMechanic, Double price,List<KeyboardReview> keyboardReview) {
        this.id=id;
        this.category=category;
        this.modelName = modelName;
        this.type = type;
        this.isLightened = isLightened;
        this.isMechanic=isMechanic;
        this.price = price;
        this.keyboardReview=keyboardReview;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public KeyboardType getType() {
        return type;
    }

    public void setType(KeyboardType type) {
        this.type = type;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<KeyboardReview> getKeyboardReview() {
        return keyboardReview;
    }

    public void setKeyboardReview(List<KeyboardReview> keyboardReview) {
        this.keyboardReview = keyboardReview;
    }
}
