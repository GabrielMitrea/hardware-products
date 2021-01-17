package store.Products.querys;

public class ProductQuerys {

    public final static String GET_PRODUCTS_SQL="select c.categoryName, p.productName, p.productPrice\n"+
            "from proiect_java.product p inner join proiect_java.category c\n" +
            "on p.categoryId=c.categoryId";
    public final static String ADD_PRODUCT_SQL="insert into product(productId,categoryId,productName,productPrice) values (null,?,?,?)";
    public final static String DELETE_PRODUCT_SQL="delete from product where productId=?";
    public final static String UPDATE_PRODUCT_SQL="update product p set p.productPrice=? where p.productId=?";
}
