package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.Headset;
import store.Products.entities.types.HeadsetType;
import store.Products.repository.HeadsetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HeadsetService {

    @Autowired
    private HeadsetRepository headsetRepository;


    public List<Headset> getHeadset(HeadsetType type, String sound){
        return headsetRepository.getHeadset(type,sound);
    }

    public Headset addNewHeadset(Headset headset){
        return headsetRepository.addNewHeadset(headset);
    }

    public Headset getHeadsetById(long headsetId){
        Optional<Headset> headsetOptional=headsetRepository.getHeadsetById(headsetId);
        if(headsetOptional.isPresent()){
            return headsetOptional.get();
        }else throw new ProductNotFoundException("Headset with Id: " + headsetId + " not found " );
    }

    public Headset updateHeadset(Headset headset,long headsetId){
        return headsetRepository.updateHeadset(headset, headsetId);
    }
}

