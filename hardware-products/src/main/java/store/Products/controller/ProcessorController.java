package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<Processor> getProcessor(@RequestParam(required = false) String core, @RequestParam(required = false) String series){
        return processorService.getProcessor(core,series);
    }

    @PostMapping
    public ResponseEntity<Processor> addNewProcessor(
            @Valid
            @RequestBody Processor processor){
        Processor addProcessor=processorService.addNewProcessor(processor);
        return ResponseEntity
                .created(URI.create("/processor/" + addProcessor.getProcessorId()))
                .body(addProcessor);
    }

    @GetMapping("/{processorId}")
    public Processor getProcessorById(@PathVariable long processorId){
        return processorService.getProcessorById(processorId);
    }
    @PutMapping("/{processorId}")
    public Processor updateProcessor(@RequestBody Processor processor, @PathVariable long processorId){
        return processorService.updateProcessor(processor, processorId);
    }

}
