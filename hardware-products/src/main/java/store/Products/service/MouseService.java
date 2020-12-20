package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.Mouse;
import store.Products.entities.types.MouseType;
import store.Products.repository.MouseRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MouseService {

    @Autowired
    private MouseRepository mouseRepository;

    public List<Mouse> getMouse(MouseType type, String maxResolution){
        return mouseRepository.getMouse(type,maxResolution);
    }

    public Mouse getMouseById(long mouseId){
        Optional<Mouse> mouseOptional=mouseRepository.getMouseById(mouseId);
        if(mouseOptional.isPresent()){
            return mouseOptional.get();
        }else throw new ProductNotFoundException("Mouse with Id: " + mouseId + " not found " );
    }
    public Mouse addNewMouse(Mouse mouse){
        return mouseRepository.addNewMouse(mouse);
    }


    public Mouse updateMouse(Mouse mouse,long mouseId){
        return mouseRepository.updateMouse(mouse, mouseId);
    }
}
