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

//    public List<Laptop> getLaptop(LaptopType type, String gpuModel){
//        return laptopRepository.getLaptop(type, gpuModel);
//    }
//
//    public Laptop addNewLaptop(Laptop laptop){
//        return laptopRepository.addNewLaptop(laptop);
//    }
//
//
//    public Laptop getLaptopById(long laptopId){
//        Optional<Laptop> laptopOptional=laptopRepository.getLaptopById(laptopId);
//        if(laptopOptional.isPresent()){
//            return laptopOptional.get();
//        }else throw new ProductNotFoundException("Laptop with Id: " +laptopId+ " not found " );
//    }
//
//    public Laptop updateLaptop(Laptop laptop, long laptopId){
//        return laptopRepository.updateLaptop(laptop, laptopId);
//    }

    public List<Laptop> getLaptop(){
       return laptopRepository.getLaptop();
}

    public List<LaptopProduct> getLaptopProduct(){
        return laptopRepository.getLaptopProduct();
    }
    public List<Laptop> addNewLaptop(Laptop laptop){
        return laptopRepository.addNewLaptop(laptop);
    }
    public List<Laptop> deleteLaptop(int id){
        return laptopRepository.deleteLaptop(id);
    }
}
