package store.Products.querys;

public class OrderQuerys {
    public final static String GET_ORDER_SQL="select o.orderNumber, p.productName, c.firstName, c.lastName, c.phoneNumber, c.address, o.dateCreated, o.expectedShipping\n"+
            "from proiect_java.order o inner join proiect_java.product p\n"+
            "on o.productId=p.productId\n"+
            "inner join proiect_java.customer c\n"+
            "on o.customerId=c.customerId";

    public final static String ADD_ORDER_SQL="insert into proiect_java.order(orderId,customerId,productId,orderNumber,dateCreated,expectedShipping) values (null,?,?,?,?,?)";
    public final static String DELETE_ORDER_SQL="delete from proiect_java.order where orderId=?";
}
