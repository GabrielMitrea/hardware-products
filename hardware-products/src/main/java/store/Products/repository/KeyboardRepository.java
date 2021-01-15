package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.KeyboardProduct;
import store.Products.entities.products.Keyboard;
import store.Products.querys.KeyboardQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


import static store.Products.querys.KeyboardQuerys.ADD_KEYBOARD_SQL;


@Repository
public class KeyboardRepository {

//    public static List<Keyboard> keyboards= new ArrayList<>();
//    public static List<KeyboardReview> keyboardReview=new ArrayList<>();
//
//    public KeyboardRepository(){
//
//
//        KeyboardReview kr1=new KeyboardReview("Gabi","Very nice product");
//        keyboardReview.add(kr1);
//
//        Keyboard k1=new Keyboard(214124214, ProductType.Keyboard,"Tastatura Gaming Razer Ornata V2",KeyboardType.Wired,"Da","Da", 294.99,null);
//        Keyboard k2=new Keyboard(525762431, ProductType.Keyboard,"astatura Gaming T-Dagger Bermuda TGK312 ",KeyboardType.Wired,"Da","Da", 239.99,keyboardReview);
//        Keyboard k3=new Keyboard(352352157, ProductType.Keyboard,"Tastatura cu fir MYRIA MY8518",KeyboardType.Wired,"Nu","Nu", 39.90,null);
//        Keyboard k4=new Keyboard(532523523, ProductType.Keyboard,"Tastatura Gaming MARVO K629G",KeyboardType.Wired,"Nu","Nu", 99.00,null);
//        Keyboard k5=new Keyboard(743571123, ProductType.Keyboard,"Tastatura Gaming Logitech G915 LIGHTSPEED ",KeyboardType.Wireless,"Da","Da", 1130.00,null);
//        Keyboard k6=new Keyboard(235412541, ProductType.Keyboard,"Tastatura Gaming Logitech G613 ",KeyboardType.Wireless,"Nu","Da", 649.99,null);
//        keyboards.add(k1);
//        keyboards.add(k2);
//        keyboards.add(k3);
//        keyboards.add(k4);
//        keyboards.add(k5);
//        keyboards.add(k6);
//
//    }
//    public List<Keyboard> getKeyboard(KeyboardType type, String isLightened){
//        return keyboards.stream()
//                .filter(keyboard -> {
//                    if(type==null && isLightened==null){
//                        return true;
//                    }
//                    else
//                    if (type != null) {
//                        if (isLightened != null) {
//
//                            return type.equals(keyboard.getType()) && isLightened.equals(keyboard.getIsLightened());
//                        } else {
//                            return type.equals(keyboard.getType());
//                        }
//                    } else {
//                        return isLightened.equals(keyboard.getIsLightened());
//                    }
//
//
//                })
//                .collect(Collectors.toList());
//    }
//
//    public Keyboard addNewKeyboard(Keyboard keyboard){
//        keyboard.setKeyboardId(Math.abs(new Random().nextInt()));
//        keyboards.add(keyboard);
//        return keyboard;
//    }
//
//    public Optional<Keyboard> getKeyboardById(long keyboardId){
//       return keyboards.stream()
//                .filter(keyboard -> keyboard.getKeyboardId()==keyboardId)
//                .findFirst();
//    }
//
//    public Keyboard updateKeyboard(Keyboard keyboard, long keyboardId){
//        keyboards.stream()
//                .forEach(upKeyboard-> {
//                    if(upKeyboard.getKeyboardId()==keyboardId){
//                        upKeyboard.setCategory(keyboard.getCategory());
//                        upKeyboard.setModelName(keyboard.getModelName());
//                        upKeyboard.setType(keyboard.getType());
//                        upKeyboard.setIsLightened(keyboard.getIsLightened());
//                        upKeyboard.setIsMechanic(keyboard.getIsMechanic());
//                        upKeyboard.setPrice(keyboard.getPrice());
//                        upKeyboard.setKeyboardReview(keyboard.getKeyboardReview());
//                    }
//                });
//        return keyboards.stream()
//                .filter(upKeyboard->upKeyboard.getKeyboardId()==keyboardId)
//                .findFirst()
//                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Keyboard> getKeyboard(){
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD_SQL,new BeanPropertyRowMapper<>(Keyboard.class));
    }


    public List<KeyboardProduct> getKeyboardProduct(){
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD1_SQL,new BeanPropertyRowMapper<>(KeyboardProduct.class));
    }
    public List<Keyboard> addNewKeyboard(Keyboard keyboard){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_KEYBOARD_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, keyboard.getCategoryName());
            preparedStatement.setString(2, keyboard.getKeyboardType());
            preparedStatement.setString(3, keyboard.getIsLightened());
            preparedStatement.setString(4, keyboard.getIsMechanic());
            preparedStatement.setInt(5,keyboard.getProductId());
            return preparedStatement;
        }, keyHolder);
        keyboard.setProductId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD_SQL,new BeanPropertyRowMapper<>(Keyboard.class));

    }
    public List<Keyboard> deleteKeyboard(int id){
        jdbcTemplate.update(KeyboardQuerys.DELETE_KEYBOARD_SQL,id);
        return jdbcTemplate.query(KeyboardQuerys.GET_KEYBOARD_SQL,new BeanPropertyRowMapper<>(Keyboard.class));
    }
}
