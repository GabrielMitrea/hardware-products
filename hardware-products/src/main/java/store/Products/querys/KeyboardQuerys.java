package store.Products.querys;

public class KeyboardQuerys {

//    public final static String GET_KEYBOARD_SQL="select k.keyboardId, c.categoryName,  k.keyboardType, k.isLightened,  k.isMechanic,  k.productId\n" +
//            "from proiect_java.category c inner join proiect_java.keyboard k\n " +
//            "ON k.categoryId=c.categoryId";


    public final static String GET_KEYBOARD1_SQL="select p.productName, k.keyboardType, k.isLightened, k.isMechanic, p.productPrice\n" +
            "from proiect_java.keyboard k inner join proiect_java.product p\n" +
            "on k.productId=p.productId";

    public final static String ADD_KEYBOARD_SQL="insert into keyboard(keyboardId,keyboardType,isLightened,isMechanic,productId) values (null,?,?,?,?)";
    public final static String DELETE_KEYBOARD_SQL="delete from keyboard where keyboardId=?";
}
