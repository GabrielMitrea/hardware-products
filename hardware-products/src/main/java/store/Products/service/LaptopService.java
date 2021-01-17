package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.LaptopProduct;
import store.Products.entities.products.Laptop;
import store.Products.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;


    public List<LaptopProduct> getLaptopProduct(){
        return laptopRepository.getLaptopProduct();
    }
    public List<Laptop> addNewLaptop(Laptop laptop){
        return laptopRepository.addNewLaptop(laptop);
    }
    public void deleteLaptop(int id){
         laptopRepository.deleteLaptop(id);
    }
}
