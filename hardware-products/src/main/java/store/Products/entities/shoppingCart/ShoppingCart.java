package store.Products.entities.shoppingCart;

public class ShoppingCart {

    private int cartId;
    private int productId;
    private int quantity;
    private double totalPrice;

    public ShoppingCart(){}



    public ShoppingCart(int cartId,int productId,int quantity, double totalPrice) {
        this.cartId=cartId;
        this.productId=productId;
        this.quantity=quantity;
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


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
