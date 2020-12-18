package store.Products.model.products;


import org.hibernate.validator.constraints.NotBlank;
import store.Products.model.ProductCategory;
import store.Products.model.reviews.MouseReview;
import store.Products.model.types.MouseType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


public class Mouse {

    private long id;
    @NotNull(message = "Product category cannot be blank")
    private ProductCategory category;

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

    public Mouse(long id,ProductCategory category,String modelName, MouseType type, String maxResolution, String interfacee, Double price, List<MouseReview> mouseReview) {
        this.id=id;
        this.category=category;
        this.modelName = modelName;
        this.type = type;
        this.maxResolution = maxResolution;
        this.interfacee=interfacee;
        this.price = price;
        this.mouseReview=mouseReview;
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
