package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.ProcessorProduct;
import store.Products.entities.products.Processor;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.Processor;
import store.Products.repository.ProcessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessorService {

    @Autowired
    private ProcessorRepository processorRepository;

   public List<ProcessorProduct> getProcessorProduct(){
        return processorRepository.getProcessorProduct();
   }

    public List<Processor> addNewProcessor(Processor processor){
        return processorRepository.addNewProcessor(processor);
    }
    public void deleteProcessor(int id){
         processorRepository.deleteProcessor(id);
    }
}
