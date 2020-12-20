package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.products.Laptop;
import store.Products.entities.types.LaptopType;
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

    @GetMapping("/{laptopId}")
    public Laptop getLaptopById(@PathVariable long laptopId){
        return laptopService.getLaptopById(laptopId);
    }

    @PostMapping
    public ResponseEntity<Laptop> addNewLaptop(
            @Valid
            @RequestBody Laptop laptop){
        Laptop addLaptop=laptopService.addNewLaptop(laptop);
        return ResponseEntity
                .created(URI.create("/laptop/" + addLaptop.getLaptopId()))
                .body(addLaptop);
    }
    @PutMapping("/{laptopId}")
    public Laptop updateLaptop(@RequestBody Laptop laptop, @PathVariable long laptopId){
        return laptopService.updateLaptop(laptop, laptopId);
    }
}
