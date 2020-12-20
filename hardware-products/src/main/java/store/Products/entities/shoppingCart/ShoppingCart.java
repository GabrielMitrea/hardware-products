package store.Products.entities.shoppingCart;

public class ShoppingCart {

    private int cartId;
    private int productId;
    private String productName;
    private double totalPrice;

    public ShoppingCart(){}

    public ShoppingCart(int productId, String productName, double totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.totalPrice = totalPrice;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
