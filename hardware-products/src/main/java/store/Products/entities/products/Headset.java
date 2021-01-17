package store.Products.entities.products;

import javax.validation.constraints.NotNull;


public class Headset {

    private int headsetId;
    private String headsetType;
    private String technology;
    private String sound;
    private String conectivity;
    private int productId;
    public Headset(){}


    public Headset(int headsetId, String headsetType,  String technology,  String sound,  String conectivity,int productId) {
        this.headsetId=headsetId;
        this.headsetType = headsetType;
        this.technology = technology;
        this.sound = sound;
        this.conectivity = conectivity;
        this.productId=productId;
    }

    public int getHeadsetId() {
        return headsetId;
    }

    public void setHeadsetId(int headsetId) {
        this.headsetId = headsetId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
