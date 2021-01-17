package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.LaptopProduct;
import store.Products.entities.products.Laptop;
import store.Products.mapper.ProductMapper;
import store.Products.service.LaptopService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/laptop")
public class LaptopController {
    
    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public List<LaptopProduct> getLaptopProduct(){
        return laptopService.getLaptopProduct();
    }


    @PostMapping("/new")
    public ResponseEntity<List<Laptop>> addNewLaptop(
             @Valid @RequestBody Laptop laptop){
         laptopService.addNewLaptop(laptop);
        return ResponseEntity.created(null).build();

    }
    @DeleteMapping("/delete")
    public void deleteLaptop(@RequestParam int id){
        laptopService.deleteLaptop(id);
    }

}
