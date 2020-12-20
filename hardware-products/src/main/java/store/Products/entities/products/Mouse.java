package store.Products.entities.products;


import store.Products.entities.reviews.MouseReview;
import store.Products.entities.types.MouseType;
import store.Products.entities.types.ProductType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


public class Mouse {

    private long mouseId;
    @NotNull(message = "Product category cannot be blank")
    private ProductType category;

    @NotNull(message = "Model name cannot be null")
    private String modelName;
    @NotNull(message = "Type cannot be null")

    private MouseType type;
    @NotNull(message = "Max resolution cannot be null")

    private String maxResolution;
    @NotNull(message = "Interface cannot be null")

    private String interfacee;
    @NotNull(message = "Price cannot be null")
    @Min(1)
    private Double price;
    private List<MouseReview> mouseReview;

    public Mouse(){}

    public Mouse(long mouseId, ProductType category, String modelName, MouseType type, String maxResolution, String interfacee, Double price, List<MouseReview> mouseReview) {
        this.mouseId=mouseId;
        this.category=category;
        this.modelName = modelName;
        this.type = type;
        this.maxResolution = maxResolution;
        this.interfacee=interfacee;
        this.price = price;
        this.mouseReview=mouseReview;
    }

    public long getMouseId() {
        return mouseId;
    }

    public void setMouseId(long mouseId) {
        this.mouseId = mouseId;
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

    public MouseType getType() {
        return type;
    }

    public void setType(MouseType type) {
        this.type = type;
    }

    public String getmaxResolution() {
        return maxResolution;
    }

    public void setmaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getInterfacee() {
        return interfacee;
    }

    public void setInterfacee(String interfacee) {
        this.interfacee = interfacee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<MouseReview> getMouseReview() {
        return mouseReview;
    }

    public void setMouseReview(List<MouseReview> mouseReview) {
        this.mouseReview = mouseReview;
    }
}
