package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.model.products.Processor;
import store.Products.model.products.Processor;
import store.Products.repository.ProcessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessorService {

    @Autowired
    private ProcessorRepository processorRepository;

    public List<Processor> getProcessor(String core, String series){
        return processorRepository.getProcessor(core,series);
    }

    public Processor addNewProcessor(Processor processor){
        return processorRepository.addNewProcessor(processor);
    }
    public Processor getProcessorById(long id){
        Optional<Processor> processorOptional=processorRepository.getProcessorById(id);
        if(processorOptional.isPresent()){
            return processorOptional.get();
        }else throw new ProductNotFoundException("Processor with id: " +id+ " not found " );
    }
}
