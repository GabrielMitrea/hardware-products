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



        processors.add(new Processor(426182390, ProductType.Processor,"Procesor AMD Ryzen 5 3600 ","Matisse","3.6 GHz","AM4","Ryzen 5 3000 Series","7 nm",999.99,null));
        processors.add(new Processor(2123058562, ProductType.Processor,"Procesor AMD Ryzen 7 3700X","Matisse","3.6 Ghz","AM4","Ryzen 7 3000 Series","7 nm",22.11,null));
        processors.add(new Processor(1821735114, ProductType.Processor,"Procesor Intel Comet Lake, Core i5","Comet Lake","2.9 GHz","1200","Core i5 10th gen","14nm",699.00,null));
        processors.add(new Processor(203450619, ProductType.Processor,"Procesor Intel Core™ i7-9700K 12M Cache","Coffee Lake","3.6 GHz","1151 v2","Core i7 9th gen","14nm",1469.99,null));
        processors.add(new Processor(1787773504, ProductType.Processor,"Procesor Intel Comet Lake, Core i9 10900K ","Comet Lake","3.7 GHz","1200","Core i9 10th gen","14nm",2379.99,null));

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
