package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.Keyboard;
import store.Products.entities.types.KeyboardType;
import store.Products.repository.KeyboardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KeyboardService {

    @Autowired
    private KeyboardRepository keyboardRepository;

    public List<Keyboard> getKeyboard(KeyboardType type, String isLightened){
        return keyboardRepository.getKeyboard(type,isLightened);
    }

    public Keyboard addNewKeyboard(Keyboard keyboard){
        return keyboardRepository.addNewKeyboard(keyboard);
    }

    public Keyboard getKeyboardById(long keyboardId){

        Optional<Keyboard> keyboardOptional=keyboardRepository.getKeyboardById(keyboardId);
        if(keyboardOptional.isPresent()){
            return keyboardOptional.get();
        } else throw new ProductNotFoundException("Keyboard with Id: " + keyboardId + " not found ");
    }
    public Keyboard updateKeyboard(Keyboard keyboard,long keyboardId){
        return keyboardRepository.updateKeyboard(keyboard, keyboardId);
    }
}
