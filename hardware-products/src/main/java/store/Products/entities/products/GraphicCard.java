package store.Products.entities.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class GraphicCard {


    private int graphicCardId;

    private String categoryName;

    @NotNull(message = "Memory size cannot be null")
    private String memorySize;

    @NotNull(message = "Memory type  cannot be null")
    private String memoryType;

    @NotNull(message = "Interface cannot be null")
    private String interfacee;

    private int productId;



    public GraphicCard(){}

    public GraphicCard(int graphicCardId, String categoryName,  String memorySize,    String memoryType,  String interfacee, int productId) {
        this.graphicCardId = graphicCardId;
        this.categoryName = categoryName;
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.interfacee = interfacee;
        this.productId = productId;
    }

    public int getGraphicCardId() {
        return graphicCardId;
    }

    public void setGraphicCardId(int graphicCardId) {
        this.graphicCardId = graphicCardId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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


}
