package store.Products.entities.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class Mouse {

    private int mouseId;
    private String mouseType;
    private String maxResolution;
    private String interfacee;
    private int productId;


    public Mouse(){}

    public Mouse(String mouseType,  String maxResolution,  String interfacee) {
        this.mouseType = mouseType;
        this.maxResolution = maxResolution;
        this.interfacee = interfacee;

    }

    public Mouse(int mouseId, String mouseType,  String maxResolution,  String interfacee, int productId) {
        this.mouseId = mouseId;
        this.mouseType = mouseType;
        this.maxResolution = maxResolution;
        this.interfacee = interfacee;
        this.productId=productId;
    }

    public int getMouseId() {
        return mouseId;
    }

    public void setMouseId(int mouseId) {
        this.mouseId = mouseId;
    }


    public String getMouseType() {
        return mouseType;
    }

    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getInterfacee() {
        return interfacee;
    }

    public void setInterfacee(String interfacee) {
        this.interfacee = interfacee;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
