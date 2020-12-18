package store.Products.model;

import store.Products.model.products.Laptop;
import store.Products.model.products.HardwareProducts;

import java.util.List;

public class Store {

    private String name;
    private String location;
    private String workProgram;
    private List<HardwareProducts> hardwareProducts;
    private List<Laptop> Laptops;

    public Store(){

    }

    public Store(String name, String location, String workProgram, List<HardwareProducts> hardwareProducts, List<Laptop> Laptops) {
        this.name = name;
        this.location = location;
        this.workProgram = workProgram;
        this.hardwareProducts = hardwareProducts;
        this.Laptops = Laptops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkProgram() {
        return workProgram;
    }

    public void setWorkProgram(String workProgram) {
        this.workProgram = workProgram;
    }

    public List<HardwareProducts> gethardwareProducts() {
        return hardwareProducts;
    }

    public void sethardwareProducts(List<HardwareProducts> hardwareProducts) {
        this.hardwareProducts = hardwareProducts;
    }

    public List<Laptop> getLaptops() {
        return Laptops;
    }

    public void setLaptops(List<Laptop> Laptops) {
        this.Laptops = Laptops;
    }
}
