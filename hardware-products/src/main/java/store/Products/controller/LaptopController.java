package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.model.products.Laptop;
import store.Products.model.products.Laptop;
import store.Products.model.products.Laptop;
import store.Products.model.types.LaptopType;
import store.Products.service.LaptopService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    
    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public List<Laptop> getLaptop(@RequestParam(required = false) LaptopType type, @RequestParam(required = false) String gpuModel){
        return laptopService.getLaptop(type, gpuModel);
    }

    @DeleteMapping("/deleteLaptop/{id}")
    public List<Laptop> deleteLaptop(@PathVariable long id){
        return laptopService.deleteLaptop(id);
    }
    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable long id){
        return laptopService.getLaptopById(id);
    }

    @PostMapping
    public ResponseEntity<Laptop> addNewLaptop(
            @Valid
            @RequestBody Laptop laptop){
        Laptop addLaptop=laptopService.addNewLaptop(laptop);
        return ResponseEntity
                .created(URI.create("/laptop/" + addLaptop.getId()))
                .body(addLaptop);
    }
}
