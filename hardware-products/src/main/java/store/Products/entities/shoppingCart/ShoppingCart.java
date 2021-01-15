package store.Products.entities.shoppingCart;

public class ShoppingCart {

    private int cartId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;

    public ShoppingCart(){}

    public ShoppingCart(int cartId,int productId,String productName,int quantity, double price, double totalPrice) {
        this.cartId=cartId;
        this.productId=productId;
        this.productName = productName;
        this.quantity=quantity;
        this.price = price;
        this.totalPrice=totalPrice;
    }



    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        totalPrice=price*quantity;
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
