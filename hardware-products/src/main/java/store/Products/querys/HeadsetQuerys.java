package store.Products.querys;

public class HeadsetQuerys {

//    public final static String GET_HEADSET_SQL="select h.headsetId, c.categoryName, h.headsetType, h.technology,  h.sound, h.conectivity, h.productId\n" +
//            "from proiect_java.category c inner join proiect_java.headset h\n " +
//            "ON h.categoryId=c.categoryId";


    public final static String GET_HEADSET1_SQL="select p.productName, h.headsetType, h.technology, h.sound, h.conectivity, p.productPrice\n" +
            "from proiect_java.headset h inner join proiect_java.product p\n" +
            "on h.productId=p.productId";


    public final static String ADD_HEADSET_SQL="insert into headset(headsetId,headsetType,technology,sound,conectivity,productId) values (null,?,?,?,?,?)";
    public final static String DELETE_HEADSET_SQL="delete from headset where headsetId=?";
}
