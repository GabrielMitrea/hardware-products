package store.Products.model.products;

import store.Products.model.ProductCategory;
import store.Products.model.reviews.GraphicCardReview;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class GraphicCard {

    private long id;
    @NotNull(message = "Category cannot be null")
    private ProductCategory category;

    @NotNull(message = "Model name cannot be null")
    private String modelName;

    @NotNull(message = "Memory size cannot be null")
    private String memorySize;

    @NotNull(message = "Memory type  cannot be null")
    private String memoryType;

    @NotNull(message = "Interface cannot be null")
    private String interfacee;

    @NotNull(message = "Price cannot be null")
    @Min(1)
    private double price;
    private List<GraphicCardReview> graphicCardReview;

    public GraphicCard(){}

    public GraphicCard(long id,ProductCategory category,String modelName, String memorySize, String memoryType, String interfacee, double price,List<GraphicCardReview> graphicCardReview) {
        this.id=id;
        this.category=category;
        this.modelName = modelName;
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.interfacee = interfacee;
        this.price = price;
        this.graphicCardReview=graphicCardReview;
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

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
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

    public List<GraphicCardReview> getGraphicCardReview() {
        return graphicCardReview;
    }

    public void setGraphicCardReview(List<GraphicCardReview> graphicCardReview) {
        this.graphicCardReview = graphicCardReview;
    }
}
