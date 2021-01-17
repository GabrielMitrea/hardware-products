package store.Products.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ShoppingCartRequest {

    @NotBlank(message = "the product name cannot be null")
    private String productName;
    @NotNull(message = "the quantity of the product cannot be null")
    private int quantity;
    @NotNull(message = "the price of the product cannot be null")
    private double productPrice;
    @NotNull(message = "total price cannot be null")
    private double totalPrice;

    public ShoppingCartRequest(){}

    public ShoppingCartRequest(String productName, int quantity, double productPrice, double totalPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalPrice() {
        totalPrice=productPrice*quantity;
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}