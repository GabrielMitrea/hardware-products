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
//
//
//
//
//    public List<Headset> getHeadset(HeadsetType type, String sound){
//        return headsetRepository.getHeadset(type,sound);
//    }
//
//    public Headset addNewHeadset(Headset headset){
//        return headsetRepository.addNewHeadset(headset);
//    }
//
//    public Headset getHeadsetById(long headsetId){
//        Optional<Headset> headsetOptional=headsetRepository.getHeadsetById(headsetId);
//        if(headsetOptional.isPresent()){
//            return headsetOptional.get();
//        }else throw new ProductNotFoundException("Headset with Id: " + headsetId + " not found " );
//    }
//
//    public Headset updateHeadset(Headset headset,long headsetId){
//        return headsetRepository.updateHeadset(headset, headsetId);
//    }


    @Autowired
    private HeadsetRepository headsetRepository;

    public List<Headset> getHeadset(){
        return headsetRepository.getHeadset();
    }

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

