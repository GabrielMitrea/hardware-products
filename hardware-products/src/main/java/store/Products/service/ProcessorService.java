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

//    public List<Processor> getProcessor(String core, String series){
//        return processorRepository.getProcessor(core,series);
//    }
//
//    public Processor addNewProcessor(Processor processor){
//        return processorRepository.addNewProcessor(processor);
//    }
//    public Processor getProcessorById(long processorId){
//        Optional<Processor> processorOptional=processorRepository.getProcessorById(processorId);
//        if(processorOptional.isPresent()){
//            return processorOptional.get();
//        }else throw new ProductNotFoundException("Processor with Id: " +processorId+ " not found " );
//    }
//
//    public Processor updateProcessor(Processor processor, long processorId){
//        return processorRepository.updateProcessor(processor, processorId);
//    }

    public List<Processor> getProcessor(){
       return processorRepository.getProcessor();
}
   public List<ProcessorProduct> getProcessorProduct(){
        return processorRepository.getProcessorProduct();
   }

    public List<Processor> addNewProcessor(Processor processor){
        return processorRepository.addNewProcessor(processor);
    }
    public List<Processor> deleteProcessor(int id){
        return processorRepository.deleteProcessor(id);
    }
}
