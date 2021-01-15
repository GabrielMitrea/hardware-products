package store.Products.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerRequest {


    @NotBlank(message = "first name cannot be null")
    private String firstName;
    @NotBlank(message = "last name cannot be null")
    private String lastName;
    @NotBlank(message = "email cannot be null")
    private String email;
    @NotBlank(message = "phone number cannot be null")
    private String phoneNumber;
    @NotBlank(message = "country cannot be null")
    private String country;
    @NotBlank(message = "address cannot be null")
    private String address;

    public CustomerRequest(){}

    public CustomerRequest(String firstName, String lastName, String email, String phoneNumber, String country, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
