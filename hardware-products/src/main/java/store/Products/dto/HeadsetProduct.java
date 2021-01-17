package store.Products.dto;

import store.Products.entities.products.Headset;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HeadsetProduct {

    @NotBlank(message = "product name cannot be null")
    private String productName;
    @NotBlank(message = "the type of the headset cannot be null")
    private String headsetType;
    @NotBlank(message = "the technology cannot be null")
    private String technology;
    @NotBlank(message = "the sound cannot be null")
    private String sound;
    @NotBlank(message = "the conectivity cannot be null")
    private String conectivity;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public HeadsetProduct(){}

    public HeadsetProduct(String productName, String headsetType, String technology, String sound, String conectivity, double productPrice) {
        this.productName = productName;
        this.headsetType = headsetType;
        this.technology = technology;
        this.sound = sound;
        this.conectivity = conectivity;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getHeadsetType() {
        return headsetType;
    }

    public void setHeadsetType(String headsetType) {
        this.headsetType = headsetType;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getConectivity() {
        return conectivity;
    }

    public void setConectivity(String conectivity) {
        this.conectivity = conectivity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
