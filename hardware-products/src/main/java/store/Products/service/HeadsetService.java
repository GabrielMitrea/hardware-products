package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.HeadsetProduct;
import store.Products.entities.products.Headset;
import store.Products.repository.HeadsetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HeadsetService {

    @Autowired
    private HeadsetRepository headsetRepository;


    public List<HeadsetProduct> getHeadsetProduct(){
        return headsetRepository.getHeadsetProduct();
    }
    public List<Headset> addNewHeadset(Headset headset){
        return headsetRepository.addNewHeadset(headset);
    }
    public void deleteHeadset(int id){
         headsetRepository.deleteHeadset(id);
    }
}

