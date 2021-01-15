package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.KeyboardProduct;
import store.Products.dto.MouseProduct;
import store.Products.entities.products.Keyboard;
import store.Products.service.KeyboardService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/keyboard")
public class KeyboardController {

    @Autowired
    private KeyboardService keyboardService;

    @GetMapping
    public List<KeyboardProduct> getKeyboardProduct(){
        return keyboardService.getKeyboardProduct();
    }


    @PostMapping("/new")
    public ResponseEntity<List<Keyboard>> addNewKeyboard(@RequestBody Keyboard keyboard){
         keyboardService.addNewKeyboard(keyboard);
        return ResponseEntity.created(null).build();

    }
    @DeleteMapping("/delete")
    public List<Keyboard> deleteKeyboard(@RequestParam int id){
        return keyboardService.deleteKeyboard(id);
    }

}
