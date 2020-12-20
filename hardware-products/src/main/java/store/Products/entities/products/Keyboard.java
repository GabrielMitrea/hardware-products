package store.Products.entities.products;


import store.Products.entities.reviews.KeyboardReview;
import store.Products.entities.types.KeyboardType;
import store.Products.entities.types.ProductType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Keyboard {

    private long keyboardId;
    @NotNull(message = "Category cannot be null")
    private ProductType category;
    @NotNull(message = "Model name cannot be null")
    private String modelName;
    @NotNull(message = "Type  cannot be null")
    private KeyboardType type;
    @NotNull(message = "Is lightened property cannot be null")
    private String isLightened;
    @NotNull(message = "Is mechanic property cannot be null")
    private String isMechanic;
    @NotNull(message = "Price cannot be null")
    @Min(1)
    private Double price;
    private List<KeyboardReview> keyboardReview;

    public Keyboard(){}

    public Keyboard(long keyboardId, ProductType category, String modelName, KeyboardType type, String isLightened, String isMechanic, Double price, List<KeyboardReview> keyboardReview) {
        this.keyboardId=keyboardId;
        this.category=category;
        this.modelName = modelName;
        this.type = type;
        this.isLightened = isLightened;
        this.isMechanic=isMechanic;
        this.price = price;
        this.keyboardReview=keyboardReview;
    }

    public long getKeyboardId() {
        return keyboardId;
    }

    public void setKeyboardId(long keyboardId) {
        this.keyboardId = keyboardId;
    }

    public ProductType getCategory() {
        return category;
    }

    public void setCategory(ProductType category) {
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
