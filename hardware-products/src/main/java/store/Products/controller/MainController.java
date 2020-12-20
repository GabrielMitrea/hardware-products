package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.store.Store;
import store.Products.entities.store.Products;
import store.Products.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/store")
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping("/Products")
    public List<Products> getProducts(){
        return mainService.getProducts();
    }

    @GetMapping
    public List<Store> getStoreList(){
       return mainService.getStoreList();
    }


    @DeleteMapping("/deleteProduct/{id}")
    public List<Products> deleteProduct(@PathVariable long id){
        return mainService.deleteProduct(id);
    }
}
