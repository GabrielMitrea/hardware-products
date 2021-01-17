package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.KeyboardProduct;
import store.Products.entities.products.Keyboard;
import store.Products.repository.KeyboardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KeyboardService {

    @Autowired
    private KeyboardRepository keyboardRepository;

    public List<KeyboardProduct> getKeyboardProduct(){
        return keyboardRepository.getKeyboardProduct();
    }
    public List<Keyboard> addNewKeyboard(Keyboard keyboard){
        return keyboardRepository.addNewKeyboard(keyboard);
    }
    public void deleteKeyboard(int id){  keyboardRepository.deleteKeyboard(id);
    }
}
