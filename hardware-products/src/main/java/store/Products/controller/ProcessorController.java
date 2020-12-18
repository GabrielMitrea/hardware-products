package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.model.products.Mouse;
import store.Products.model.products.Processor;
import store.Products.model.products.Processor;
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
    public List<Processor> getProcessor(@RequestParam(required = false) String core, @RequestParam(required = false) String series){
        return processorService.getProcessor(core,series);
    }

    @PostMapping
    public ResponseEntity<Processor> addNewProcessor(
            @Valid
            @RequestBody Processor processor){
        Processor addProcessor=processorService.addNewProcessor(processor);
        return ResponseEntity
                .created(URI.create("/processor/" + addProcessor.getId()))
                .body(addProcessor);
    }

    @GetMapping("/{id}")
    public Processor getProcessorById(@PathVariable long id){
        return processorService.getProcessorById(id);
    }

}
