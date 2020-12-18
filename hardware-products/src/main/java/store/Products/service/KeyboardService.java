package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.model.products.Keyboard;
import store.Products.model.products.Mouse;
import store.Products.model.types.KeyboardType;
import store.Products.repository.KeyboardRepository;

import java.security.Key;
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

    public Keyboard getKeyboardById(long id){

        Optional<Keyboard> keyboardOptional=keyboardRepository.getKeyboardById(id);
        if(keyboardOptional.isPresent()){
            return keyboardOptional.get();
        } else throw new ProductNotFoundException("Keyboard with id: " + id + " not found ");
    }
}
