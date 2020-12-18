package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.model.Store;
import store.Products.model.products.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static store.Products.repository.GraphicCardRepository.graphicCards;
import static store.Products.repository.HeadsetRepository.headsets;
import static store.Products.repository.KeyboardRepository.keyboards;
import static store.Products.repository.LaptopRepository.laptops;
import static store.Products.repository.MouseRepository.mice;
import static store.Products.repository.ProcessorRepository.processors;

@Repository
public class MainRepository {


    public static List<Store> storeList= new ArrayList<>();
    public static List<HardwareProducts> hardwareProducts =new ArrayList<>();


    public MainRepository(){

       HardwareProducts hp=new HardwareProducts(mice,keyboards,processors,graphicCards,headsets);
       hardwareProducts.add(hp);

       Store s1= new Store("PC components & laptops","Bucuresti","Luni-vineri:8:00-18:00",hardwareProducts,laptops);
       storeList.add(s1);

    }

    public List<Store> getStoreList(){
        return storeList;
    }

    public List<HardwareProducts> getHardwareProducts(){
        return hardwareProducts;
    }

    public List<HardwareProducts> deleteProduct(long id){
        hardwareProducts=hardwareProducts.stream()
                .filter(hardwareProduct->hardwareProduct.getMice().removeIf(mouse -> mouse.getId()==id) ||
                              hardwareProduct.getKeyboards().removeIf(keyboard -> keyboard.getId()==id) ||
                        hardwareProduct.getgraphicCards().removeIf(graphicCard -> graphicCard.getId()==id) ||
                        hardwareProduct.getHeadsets().removeIf(headset -> headset.getId()==id) ||
                        hardwareProduct.getProcessors().removeIf(processor -> processor.getId()==id))
                .collect(Collectors.toList());
        return hardwareProducts;
    }



}
