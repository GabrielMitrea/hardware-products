package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.model.products.Laptop;
import store.Products.model.products.Laptop;
import store.Products.model.types.LaptopType;
import store.Products.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getLaptop(LaptopType type, String gpuModel){
        return laptopRepository.getLaptop(type, gpuModel);
    }

    public Laptop addNewLaptop(Laptop laptop){
        return laptopRepository.addNewLaptop(laptop);
    }
    public List<Laptop> deleteLaptop(long id){
        return laptopRepository.deleteLaptop(id);
    }

    public Laptop getLaptopById(long id){
        Optional<Laptop> laptopOptional=laptopRepository.getLaptopById(id);
        if(laptopOptional.isPresent()){
            return laptopOptional.get();
        }else throw new ProductNotFoundException("Laptop with id: " +id+ " not found " );
    }
}
