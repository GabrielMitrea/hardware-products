package store.Products.entities.shoppingCart;

import java.util.Date;

public class Order {

    private int orderId;
    private int customerId;
    private Date dateCreated;
    private String customerName;
    private double totalPrice;

    public Order(){}

    public Order(int customerId, Date dateCreated, String customerName, double totalPrice) {
        this.customerId = customerId;
        this.dateCreated = dateCreated;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
