package store.Products.entities.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class Mouse {

    private int mouseId;
    @NotNull(message = "Product categoryName cannot be blank")
    private String categoryName;


    @NotNull(message = "Type cannot be null")

    private String mouseType;
    @NotNull(message = "Max resolution cannot be null")

    private String maxResolution;
    @NotNull(message = "Interface cannot be null")

    private String interfacee;
    private int productId;


    public Mouse(){}

    public Mouse(int mouseId,  String categoryName, String mouseType,  String maxResolution,  String interfacee, int productId) {
        this.mouseId = mouseId;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
