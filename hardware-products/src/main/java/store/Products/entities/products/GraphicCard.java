package store.Products.entities.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class GraphicCard {


    private int graphicCardId;
    private String memorySize;
    private String memoryType;
    private String interfacee;
    private int productId;



    public GraphicCard(){}

    public GraphicCard( String memorySize, String memoryType,  String interfacee) {
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.interfacee = interfacee;

    }

    public GraphicCard(int graphicCardId,  String memorySize,    String memoryType,  String interfacee, int productId) {
        this.graphicCardId = graphicCardId;
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
