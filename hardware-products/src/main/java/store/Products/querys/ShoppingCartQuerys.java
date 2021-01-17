package store.Products.querys;

public class ShoppingCartQuerys {

    public final static String GET_ITEM_CART="select * from shoppingcart";

    public final static String GET_ITEM_CART1="select p.productName, sc.quantity, p.productPrice, sc.totalPrice\n"+
            "from proiect_java.shoppingcart sc inner join proiect_java.product p\n"+
            "on sc.productId=p.productId";
    public final static String ADD_ITEM_CART= "insert into shoppingcart(cartId,productId, quantity,totalPrice) values (null,?,?,?)";
}
