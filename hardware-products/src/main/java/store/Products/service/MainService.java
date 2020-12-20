package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.entities.store.Store;
import store.Products.entities.store.Products;
import store.Products.repository.*;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public List<Store> getStoreList(){
        return mainRepository.getStoreList();
    }

    public List<Products> getProducts(){
        return mainRepository.getProducts();
    }

    public List<Products> deleteProduct(long id){
        return mainRepository.deleteProduct(id);
    }
}
