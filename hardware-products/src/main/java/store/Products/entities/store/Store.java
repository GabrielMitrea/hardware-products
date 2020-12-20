package store.Products.entities.store;

import java.util.List;

public class Store {

    private String name;
    private String location;
    private String workProgram;
    private List<Products> products;

    public Store(){

    }

    public Store(String name, String location, String workProgram, List<Products> products) {
        this.name = name;
        this.location = location;
        this.workProgram = workProgram;
        this.products = products;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
