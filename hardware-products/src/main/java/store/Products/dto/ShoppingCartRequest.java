package store.Products.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ShoppingCartRequest {

    @NotBlank(message = "the product name cannot be null")
    private String productName;
    @NotNull(message = "the quantity of the product cannot be null")
    private int quantity;
    @NotNull(message = "the price of the product cannot be null")
    private int price;
    @NotNull(message = "total price cannot be null")
    private int totalPrice;

    public ShoppingCartRequest(){}

    public ShoppingCartRequest(String productName, int quantity, int price, int totalPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        totalPrice=quantity*price;
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}