package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.model.products.Keyboard;
import store.Products.model.products.Keyboard;
import store.Products.model.types.KeyboardType;
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
    public List<Keyboard> getKeyboard(@RequestParam(required = false) KeyboardType type, @RequestParam(required = false) String isLightened){
        return keyboardService.getKeyboard(type,isLightened);
    }

    @PostMapping
    public ResponseEntity<Keyboard> addNewKeyboard(
            @Valid
            @RequestBody Keyboard keyboard){
        Keyboard addKeyboard=keyboardService.addNewKeyboard(keyboard);
        return ResponseEntity
                .created(URI.create("/keyboard/" + addKeyboard.getId()))
                .body(addKeyboard);
    }

    @GetMapping("/{id}")
    public Keyboard getKeyboardById(@PathVariable long id){
        return keyboardService.getKeyboardById(id);
    }
}
