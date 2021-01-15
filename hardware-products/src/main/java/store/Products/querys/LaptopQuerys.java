package store.Products.querys;

public class LaptopQuerys {

    public final static String GET_LAPTOP_SQL="select l.laptopId, c.categoryName,  l.laptopType, l.cpuModel, l.gpuModel, l.memoryRamSize, l.storageCapacity,  l.productId\n" +
            "from proiect_java.category c inner join proiect_java.laptop l\n " +
            "ON l.categoryId=c.categoryId";


    public final static String GET_LAPTOP1_SQL="select  c.categoryName,p.productName, l.laptopType, l.cpuModel, l.gpuModel, l.memoryRamSize,l.storageCapacity, p.productPrice\n" +
            "from proiect_java.laptop l inner join proiect_java.product p\n" +
            "on l.productId=p.productId\n" +
            "inner join proiect_java.category c\n" +
            "on l.categoryId=c.categoryId";
    public final static String ADD_LAPTOP_SQL="insert into laptop(laptopId,categoryId,laptopType,cpuModel,gpuModel,memoryRamSize, storageCapacity, productId) values (null,?,?,?,?,?,?,?)";
    public final static String DELETE_LAPTOP_SQL="delete from laptop where laptopId=?";
}
