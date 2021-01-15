package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.MouseProduct;
import store.Products.entities.products.Mouse;
import store.Products.service.MouseService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mouse")
@Validated
public class MouseController {


    @Autowired
    private MouseService mouseService;


    @GetMapping
    public List<MouseProduct> getMouseProduct(){
        return mouseService.getMouseProduct();
    }
    @PostMapping("/new")
    public ResponseEntity<List<Mouse>> addNewMouse(@RequestBody Mouse mouse){
         mouseService.addNewMouse(mouse);
        return ResponseEntity.created(null).build();

    }
    @DeleteMapping("/delete")
    public List<Mouse> deleteMouse(@RequestParam int id){
        return mouseService.deleteMouse(id);
    }


}
