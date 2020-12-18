package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.model.ProductCategory;
import store.Products.model.products.Keyboard;
import store.Products.model.products.Laptop;
import store.Products.model.products.Mouse;
import store.Products.model.types.LaptopType;
import store.Products.model.types.MouseType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class LaptopRepository {

    public static List<Laptop> laptops=new ArrayList<>();

    public LaptopRepository(){

        laptops.add(new Laptop(1609229152,ProductCategory.Laptop,"Laptop ASUS Gaming 15.6'' ROG Strix G G531GT", LaptopType.Gaming,"Intel® Core™ i7-9750H","GeForce GTX 1650","8GB DDR4","512Gb SSD",4999.99, null));
        laptops.add(new Laptop(1491888111,ProductCategory.Laptop,"Laptop ASUS Gaming 15.6'' ROG Strix G G531GT", LaptopType.Gaming,"Intel® Core™ i7-9750H","GeForce GTX 1650","8GB DDR4","512Gb SSD",4999.99, null));
        laptops.add(new Laptop(1608595386,ProductCategory.Laptop,"Laptop Lenovo Gaming 15.6'' IdeaPad 3 15IMH05", LaptopType.Gaming,"Intel® Core™ i5-10300H","GeForce GTX 1650 Ti 4GB","8GB DDR4","512GB SSD",3989.99, null));
        laptops.add(new Laptop(559695151,ProductCategory.Laptop,"Laptop ASUS Gaming 15.6'' ROG Strix G G531GT", LaptopType.Gaming,"Intel® Core™ i7-9750H","GeForce GTX 1650","8GB DDR4","512Gb SSD",4999.99, null));
        laptops.add(new Laptop(1646484793,ProductCategory.Laptop,"Laptop Lenovo Gaming 15.6'' IdeaPad 3 15IMH05", LaptopType.Gaming,"Intel® Core™ i5-10300H","GeForce GTX 1650 Ti 4GB","8GB DDR4","512GB SSD",3989.99, null));

    }

    public List<Laptop> getLaptop(LaptopType type, String gpuModel){
        return laptops.stream()
                .filter(laptop -> {
                    if(type==null && gpuModel==null){
                        return true;
                    }
                    else
                    if (type != null) {
                        if (gpuModel!= null) {

                            return type.equals(laptop.getType()) && gpuModel.equals(laptop.getgpuModel());
                        } else {
                            return type.equals(laptop.getType());
                        }
                    } else {
                        return gpuModel.equals(laptop.getgpuModel());
                    }


                })
                .collect(Collectors.toList());
    }
    public Laptop addNewLaptop(Laptop laptop){
        laptop.setId(Math.abs(new Random().nextInt()));
        laptops.add(laptop);
        return laptop;
    }

    public Optional<Laptop> getLaptopById(long id){
        return laptops.stream()
                .filter(laptop -> laptop.getId()==id)
                .findFirst();
    }

    public List<Laptop> deleteLaptop(long id){
        laptops=laptops.stream()
                .filter(laptop -> laptop.getId()!=id)
                .collect(Collectors.toList());
        return laptops;
    }
}
