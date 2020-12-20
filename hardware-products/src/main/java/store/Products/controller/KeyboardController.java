package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.products.Keyboard;
import store.Products.entities.types.KeyboardType;
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
                .created(URI.create("/keyboard/" + addKeyboard.getKeyboardId()))
                .body(addKeyboard);
    }

    @GetMapping("/{keyboardId}")
    public Keyboard getKeyboardById(@PathVariable long keyboardId){
        return keyboardService.getKeyboardById(keyboardId);
    }
    @PutMapping("/{keyboardId}")
    public Keyboard updateKeyboard(@RequestBody Keyboard keyboard, @PathVariable long keyboardId){
        return keyboardService.updateKeyboard(keyboard, keyboardId);
    }
}
