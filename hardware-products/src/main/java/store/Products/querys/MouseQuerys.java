package store.Products.querys;

public class MouseQuerys {

//    public final static String GET_MOUSE_SQL="select m.mouseId, c.categoryName, m.mouseType, m.maxResolution,  m.interfacee,  m.productId\n" +
//            "from proiect_java.category c inner join proiect_java.mouse m\n " +
//            "ON m.categoryId=c.categoryId";

    public final static String GET_MOUSE1_SQL="select  p.productName, m.mouseType, m.maxResolution, m.interfacee, p.productPrice\n" +
            "from proiect_java.mouse m inner join proiect_java.product p\n" +
            "on m.productId=p.productId";


    public final static String ADD_MOUSE_SQL="insert into mouse(mouseId,mouseType,maxResolution,interfacee,productId) values (null,?,?,?,?)";
    public final static String DELETE_MOUSE_SQL="delete from mouse where mouseId=?";

}

