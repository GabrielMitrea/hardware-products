package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.ProcessorProduct;
import store.Products.entities.products.Processor;
import store.Products.querys.ProcessorQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.ProcessorQuerys.ADD_PROCESSOR_SQL;


@Repository
public class ProcessorRepository {

//    public static List<Processor> processors=new ArrayList<>();
//
//    public ProcessorRepository(){
//
//
//
//        processors.add(new Processor(426182390, ProductType.Processor,"Procesor AMD Ryzen 5 3600 ","Matisse","3.6 GHz","AM4","Ryzen 5 3000 Series","7 nm",999.99,null));
//        processors.add(new Processor(2123058562, ProductType.Processor,"Procesor AMD Ryzen 7 3700X","Matisse","3.6 Ghz","AM4","Ryzen 7 3000 Series","7 nm",22.11,null));
//        processors.add(new Processor(1821735114, ProductType.Processor,"Procesor Intel Comet Lake, Core i5","Comet Lake","2.9 GHz","1200","Core i5 10th gen","14nm",699.00,null));
//        processors.add(new Processor(203450619, ProductType.Processor,"Procesor Intel Core™ i7-9700K 12M Cache","Coffee Lake","3.6 GHz","1151 v2","Core i7 9th gen","14nm",1469.99,null));
//        processors.add(new Processor(1787773504, ProductType.Processor,"Procesor Intel Comet Lake, Core i9 10900K ","Comet Lake","3.7 GHz","1200","Core i9 10th gen","14nm",2379.99,null));
//
//    }
//
//    public List<Processor> getProcessor(String core, String series ){
//        return processors.stream()
//                .filter(processor -> {
//                    if(core==null && series==null){
//                        return true;
//                    }
//                    else
//                    if (core != null) {
//                        if (series != null) {
//
//                            return core.equals(processor.getCore()) && series.equals(processor.getSeries());
//                        } else {
//                            return core.equals(processor.getCore());
//                        }
//                    } else {
//                        return series.equals(processor.getSeries());
//                    }
//
//
//                })
//                .collect(Collectors.toList());
//    }
//
//    public Processor addNewProcessor(Processor processor){
//        processor.setProcessorId(Math.abs(new Random().nextInt()));
//        processors.add(processor);
//        return processor;
//    }
//
//    public Optional<Processor> getProcessorById(long processorId){
//        return processors.stream()
//                .filter(processor -> processor.getProcessorId()==processorId)
//                .findFirst();
//    }
//
//    public Processor updateProcessor(Processor processor, long processorId){
//      processors.stream()
//                .forEach(upProcessor-> {
//                    if(upProcessor.getProcessorId()==processorId){
//                        upProcessor.setCategory(processor.getCategory());
//                        upProcessor.setModelName(processor.getModelName());
//                        upProcessor.setCore(processor.getCore());
//                        upProcessor.setFrequency(processor.getFrequency());
//                        upProcessor.setSocket(processor.getSocket());
//                        upProcessor.setSeries(processor.getSeries());
//                        upProcessor.setManufacturingTechnology(processor.getManufacturingTechnology());
//                        upProcessor.setPrice(processor.getPrice());
//                        upProcessor.setProcessorReview(processor.getProcessorReview());
//                    }
//                });
//        return processors.stream()
//                .filter(upProcessor->upProcessor.getProcessorId()==processorId)
//                .findFirst()
//                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
//    }
 
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Processor> getProcessor(){
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR_SQL,new BeanPropertyRowMapper<>(Processor.class));
    }

    public List<ProcessorProduct> getProcessorProduct(){
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR1_SQL,new BeanPropertyRowMapper<>(ProcessorProduct.class));
    }

    public List<Processor> addNewProcessor(Processor processor){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_PROCESSOR_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, processor.getCategoryName());
            preparedStatement.setString(2, processor.getCore());
            preparedStatement.setString(3, processor.getFrequency());
            preparedStatement.setString(4, processor.getSocket());
            preparedStatement.setString(5, processor.getSeries());
            preparedStatement.setString(6, processor.getManufacturingTechnology());
            preparedStatement.setInt(7,processor.getProductId());

            return preparedStatement;
        }, keyHolder);
        processor.setProcessorId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR_SQL,new BeanPropertyRowMapper<>(Processor.class));

    }
    public List<Processor> deleteProcessor(int id){
        jdbcTemplate.update(ProcessorQuerys.DELETE_PROCESSOR_SQL,id);
        return jdbcTemplate.query(ProcessorQuerys.GET_PROCESSOR_SQL,new BeanPropertyRowMapper<>(Processor.class));
    }

}
