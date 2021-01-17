package store.Products.entities.products;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Keyboard {

    private int keyboardId;
    private String keyboardType;
    private String isLightened;
    private String isMechanic;
    private int productId;

    public Keyboard(){}

    public Keyboard(String keyboardType, String isLightened,  String isMechanic) {
        this.keyboardType = keyboardType;
        this.isLightened = isLightened;
        this.isMechanic = isMechanic;

    }
    public Keyboard(int keyboardId, String keyboardType, String isLightened,  String isMechanic, int productId) {
        this.keyboardId = keyboardId;
        this.keyboardType = keyboardType;
        this.isLightened = isLightened;
        this.isMechanic = isMechanic;
        this.productId = productId;
    }

    public int getKeyboardId() {
        return keyboardId;
    }

    public void setKeyboardId(int keyboardId) {
        this.keyboardId = keyboardId;
    }


    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
