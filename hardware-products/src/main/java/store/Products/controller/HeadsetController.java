package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.HeadsetProduct;
import store.Products.entities.products.Headset;
import store.Products.mapper.ProductMapper;
import store.Products.service.HeadsetService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/headset")
public class HeadsetController {

    @Autowired
    private HeadsetService headsetService;


    @PostMapping("/add")
    public ResponseEntity<List<Headset>> addNewheadset(@Valid @RequestBody Headset headset){
         headsetService.addNewHeadset(headset);
        return ResponseEntity.created(null).build();

    }
    @GetMapping
    public List<HeadsetProduct> getHeadsetProduct(){
        return headsetService.getHeadsetProduct();
    }
    @DeleteMapping("/delete")
    public void deleteheadset(@RequestParam int id){
        headsetService.deleteHeadset(id);
    }

}
