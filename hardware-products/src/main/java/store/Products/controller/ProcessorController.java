package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.ProcessorProduct;
import store.Products.entities.products.Processor;
import store.Products.entities.products.Processor;
import store.Products.service.ProcessorService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/processor")
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;



     @GetMapping
     public List<ProcessorProduct> getProcessorProduct(){
        return processorService.getProcessorProduct();
     }

    @PostMapping("/new")
    public ResponseEntity<List<Processor>> addNewProcessor(@RequestBody Processor processor){
        processorService.addNewProcessor(processor);
        return ResponseEntity.created(null).build();

    }
    @DeleteMapping("/delete")
    public void deleteProcessor(@RequestParam int id){
         processorService.deleteProcessor(id);
    }


}
