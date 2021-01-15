package store.Products.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateProductDto {

    @NotNull(message = "id cannot be null")
    private int productId;
    @NotNull(message = "the price of the product cannot be null")
    @Min(1)
    private double productPrice;

    public UpdateProductDto(){}

    public UpdateProductDto(int productId, double productPrice) {
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
