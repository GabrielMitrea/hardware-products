package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.entities.store.Store;
import store.Products.entities.store.Products;


import java.util.ArrayList;
import java.util.List;
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
    public static List<Products> products =new ArrayList<>();


    public MainRepository(){

       Products hp=new Products(mice,keyboards,processors,graphicCards,headsets,laptops);
       products.add(hp);

       Store s1= new Store("PC components & laptops","Bucuresti","Luni-vineri:8:00-18:00", products);
       storeList.add(s1);

    }

    public List<Store> getStoreList(){
        return storeList;
    }

    public List<Products> getProducts(){
        return products;
    }

    public List<Products> deleteProduct(long id){
        products = products.stream()
                .filter(product->product.getMice().removeIf(mouse -> mouse.getMouseId()==id) ||
                              product.getKeyboards().removeIf(keyboard -> keyboard.getKeyboardId()==id) ||
                        product.getgraphicCards().removeIf(graphicCard -> graphicCard.getGraphicCardId()==id) ||
                        product.getHeadsets().removeIf(headset -> headset.getHeadsetId()==id) ||
                        product.getProcessors().removeIf(processor -> processor.getProcessorId()==id) ||
                        product.getLaptops().removeIf(laptop -> laptop.getLaptopId()==id))
                .collect(Collectors.toList());
        return products;
    }



}
