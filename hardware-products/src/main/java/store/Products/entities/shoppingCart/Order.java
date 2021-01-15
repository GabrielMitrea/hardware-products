package store.Products.entities.shoppingCart;


import java.sql.Date;

public class Order {

    private int orderId;
    private int customerId;
    private int productId;
    private long orderNumber;
    private Date dateCreated;
    private Date expectedShipping;

    public Order(){}

    public Order(int orderId, int customerId, int productId, long orderNumber, Date dateCreated, Date expectedShipping) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.orderNumber = orderNumber;
        this.dateCreated = dateCreated;
        this.expectedShipping = expectedShipping;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getExpectedShipping() {
        return expectedShipping;
    }

    public void setExpectedShipping(Date expectedShipping) {
        this.expectedShipping = expectedShipping;
    }
}
