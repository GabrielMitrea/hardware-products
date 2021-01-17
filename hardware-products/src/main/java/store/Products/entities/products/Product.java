package store.Products.entities.products;

public class Product {

    private int productId;
    private int categoryId;
    private String productName;
    private double productPrice;

    public Product(){

    }


    public Product(int productId, int categoryId, String productName, double productPrice) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
