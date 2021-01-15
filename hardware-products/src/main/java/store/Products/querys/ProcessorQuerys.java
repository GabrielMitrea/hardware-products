package store.Products.querys;

public class ProcessorQuerys {

    public final static String GET_PROCESSOR_SQL="select pr.processorId, c.categoryName, pr.core, pr.frequency,  pr.socket, pr.series, pr.manufacturingTechnology, pr.productId\n" +
            "from proiect_java.category c inner join proiect_java.processor pr\n " +
            "ON pr.categoryId=c.categoryId";


    public final static String GET_PROCESSOR1_SQL="select c.categoryName,p.productName, pr.core, pr.frequency, pr.socket,pr.series, pr.manufacturingTechnology, p.productPrice\n" +
            "from proiect_java.processor pr inner join proiect_java.product p\n" +
            "on pr.productId=p.productId\n" +
            "inner join proiect_java.category c\n" +
            "on pr.categoryId=c.categoryId";
    
    public final static String ADD_PROCESSOR_SQL="insert into processor(processorId,categoryId,core,frequency,socket,series,manufacturingTechnology,productId) values (null,?,?,?,?,?,?,?)";
    public final static String DELETE_PROCESSOR_SQL="delete from processor where processorId=?";
}
