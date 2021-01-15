package store.Products.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class OrderDto {

    @NotNull(message = "Order number cannot be null")
    private long orderNumber;
    @NotBlank(message = "product name cannot be null")
    private String productName;
    @NotBlank(message = "customer`s first name cannot be null")
    private String firstName;
    @NotBlank(message = "customer`s last name cannot be null")
    private String lastName;
    @NotBlank(message = "customer`s phone number cannot be null")
    private String phoneNumber;
    @NotBlank(message = "customer`s address cannot be null")
    private String address;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dateCreated;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date expectedShipping;

    public OrderDto() {
    }

    public OrderDto(@NotNull(message = "Order number cannot be null") long orderNumber, @NotBlank(message = "product name cannot be null") String productName, @NotBlank(message = "customer`s first name cannot be null") String firstName, @NotBlank(message = "customer`s last name cannot be null") String lastName, @NotBlank(message = "customer`s phone number cannot be null") String phoneNumber, @NotBlank(message = "customer`s address cannot be null") String address, Date dateCreated, Date expectedShipping) {
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateCreated = dateCreated;
        this.expectedShipping = expectedShipping;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
