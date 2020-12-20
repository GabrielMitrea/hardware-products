package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.types.ProductType;
import store.Products.entities.products.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class ProcessorRepository {

    public static List<Processor> processors=new ArrayList<>();

    public ProcessorRepository(){



        processors.add(new Processor(426182390, ProductType.Processor,"m1","c1","f1","s1","se1","mt1",22.11,null));
        processors.add(new Processor(2123058562, ProductType.Processor,"m2","c2","f2","s2","se2","mt2",22.11,null));
        processors.add(new Processor(1821735114, ProductType.Processor,"m3","c3","f3","s3","se3","mt3",22.11,null));
        processors.add(new Processor(203450619, ProductType.Processor,"m4","c4","f4","s4","se4","mt4",22.11,null));
        processors.add(new Processor(1787773504, ProductType.Processor,"m5","c5","f5","s5","se5","mt5",22.11,null));

    }

    public List<Processor> getProcessor(String core, String series ){
        return processors.stream()
                .filter(processor -> {
                    if(core==null && series==null){
                        return true;
                    }
                    else
                    if (core != null) {
                        if (series != null) {

                            return core.equals(processor.getCore()) && series.equals(processor.getSeries());
                        } else {
                            return core.equals(processor.getCore());
                        }
                    } else {
                        return series.equals(processor.getSeries());
                    }


                })
                .collect(Collectors.toList());
    }

    public Processor addNewProcessor(Processor processor){
        processor.setProcessorId(Math.abs(new Random().nextInt()));
        processors.add(processor);
        return processor;
    }

    public Optional<Processor> getProcessorById(long processorId){
        return processors.stream()
                .filter(processor -> processor.getProcessorId()==processorId)
                .findFirst();
    }

    public Processor updateProcessor(Processor processor, long processorId){
      processors.stream()
                .forEach(upProcessor-> {
                    if(upProcessor.getProcessorId()==processorId){
                        upProcessor.setCategory(processor.getCategory());
                        upProcessor.setModelName(processor.getModelName());
                        upProcessor.setCore(processor.getCore());
                        upProcessor.setFrequency(processor.getFrequency());
                        upProcessor.setSocket(processor.getSocket());
                        upProcessor.setSeries(processor.getSeries());
                        upProcessor.setManufacturingTechnology(processor.getManufacturingTechnology());
                        upProcessor.setPrice(processor.getPrice());
                        upProcessor.setProcessorReview(processor.getProcessorReview());
                    }
                });
        return processors.stream()
                .filter(upProcessor->upProcessor.getProcessorId()==processorId)
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
    }

}
