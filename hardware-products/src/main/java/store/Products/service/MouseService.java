package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.model.products.Mouse;
import store.Products.model.types.MouseType;
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

    public Mouse getMouseById(long id){
        Optional<Mouse> mouseOptional=mouseRepository.getMouseById(id);
        if(mouseOptional.isPresent()){
            return mouseOptional.get();
        }else throw new ProductNotFoundException("Mouse with id: " + id + " not found " );
    }
    public Mouse addNewMouse(Mouse mouse){
        return mouseRepository.addNewMouse(mouse);
    }


    public Mouse updateMouse(Mouse mouse,long id){
        return mouseRepository.updateMouse(mouse, id);
    }
}
