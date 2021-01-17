package store.Products.querys;

public class GraphicQuerys {

//    public final static String GET_GRAPHICCARD_SQL="select gc.graphicCardId, c.categoryName, gc.memorySize, gc.memoryType,  gc.interfacee,  gc.productId\n" +
//            "from proiect_java.category c inner join proiect_java.graphiccard gc\n " +
//            "ON gc.categoryId=c.categoryId";
    public final static String GET_GRAPHICCARD1_SQL="select p.productName, gc.memorySize, gc.memoryType, gc.interfacee, p.productPrice\n" +
            "from proiect_java.graphiccard gc inner join proiect_java.product p\n" +
            "on gc.productId=p.productId";

    public final static String ADD_GRAPHICCARD_SQL="insert into graphiccard(graphicCardId,memorySize,memoryType,interfacee,productId) values (null,?,?,?,?)";
    public final static String DELETE_GRAPHICCARD_SQL="delete from graphiccard where graphicCardId=?";



}
