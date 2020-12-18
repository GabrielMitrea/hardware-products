package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.Products.model.Store;
import store.Products.model.products.*;
import store.Products.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/store")
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping("/hardwareProducts")
    public List<HardwareProducts> getHardwareProducts(){
        return mainService.getHardwareProducts();
    }

    @GetMapping("/allProducts")
    public List<Store> getStoreList(){
       return mainService.getStoreList();
    }


    @DeleteMapping("/deleteProduct/{id}")
    public List<HardwareProducts> deleteProduct(@PathVariable long id){
        return mainService.deleteProduct(id);
    }
}
