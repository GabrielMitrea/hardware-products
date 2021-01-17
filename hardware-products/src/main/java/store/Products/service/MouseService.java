package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.MouseProduct;
import store.Products.entities.products.Mouse;
import store.Products.repository.MouseRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MouseService {

    @Autowired
    private MouseRepository mouseRepository;


    public List<MouseProduct> getMouseProduct(){
        return mouseRepository.getMouseProduct();
    }
    public List<Mouse> addNewMouse(Mouse mouse){
        return mouseRepository.addNewMouse(mouse);
    }
    public void deleteMouse(int id){
      mouseRepository.deleteMouse(id);
    }
}
