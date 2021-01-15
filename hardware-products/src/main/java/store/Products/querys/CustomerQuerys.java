package store.Products.querys;

public class CustomerQuerys {

    public final static String GET_CUSTOMER_SQL="select * from customer";
    public final static String ADD_CUSTOMER_SQL="insert into customer(customerId,firstName,lastName,email,phoneNumber,country,address) values (null,?,?,?,?,?,?)";
    public final static String DELETE_CUSTOMER_SQL="delete from customer where customerId=?";
}
