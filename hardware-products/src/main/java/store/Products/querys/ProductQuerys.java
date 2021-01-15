package store.Products.querys;

public class ProductQuerys {

    public final static String GET_PRODUCTS_SQL="select * from product";
    public final static String ADD_PRODUCT_SQL="insert into product(productId,productName,productPrice) values (null,?,?)";
    public final static String DELETE_PRODUCT_SQL="delete from product where productId=?";
    public final static String UPDATE_PRODUCT_SQL="update product p set p.productPrice=? where p.productId=?";
}
