package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.model.Store;
import store.Products.model.products.*;
import store.Products.repository.*;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public List<Store> getStoreList(){
        return mainRepository.getStoreList();
    }

    public List<HardwareProducts> getHardwareProducts(){
        return mainRepository.getHardwareProducts();
    }

    public List<HardwareProducts> deleteProduct(long id){
        return mainRepository.deleteProduct(id);
    }
}
