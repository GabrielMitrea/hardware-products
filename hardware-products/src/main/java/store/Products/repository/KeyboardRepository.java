package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.model.ProductCategory;
import store.Products.model.products.Keyboard;
import store.Products.model.products.Mouse;
import store.Products.model.reviews.KeyboardReview;
import store.Products.model.types.KeyboardType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class KeyboardRepository {

    public static List<Keyboard> keyboards= new ArrayList<>();
    public static List<KeyboardReview> keyboardReview=new ArrayList<>();

    public KeyboardRepository(){

        KeyboardReview kr1=new KeyboardReview("Gabi","Very nice product");
        keyboardReview.add(kr1);

        Keyboard k1=new Keyboard(214124214,ProductCategory.Keyboard,"t1",KeyboardType.Wireless,"Da","Nu", 209.99,null);
        Keyboard k2=new Keyboard(525762431,ProductCategory.Keyboard,"t2",KeyboardType.Wired,"Da","Nu", 500.12,keyboardReview);
        Keyboard k3=new Keyboard(352352157,ProductCategory.Keyboard,"t3",KeyboardType.Wireless,"Nu","Nu", 530.00,null);
        Keyboard k4=new Keyboard(532523523,ProductCategory.Keyboard,"t4",KeyboardType.Wired,"Nu","Nu", 99.00,null);
        Keyboard k5=new Keyboard(743571123,ProductCategory.Keyboard,"t5",KeyboardType.Wireless,"Da","Da", 70.89,null);
        Keyboard k6=new Keyboard(235412541,ProductCategory.Keyboard,"t6",KeyboardType.Wired,"Da","Da", 320.00,null);
        keyboards.add(k1);
        keyboards.add(k2);
        keyboards.add(k3);
        keyboards.add(k4);
        keyboards.add(k5);
        keyboards.add(k6);

    }
    public List<Keyboard> getKeyboard(KeyboardType type, String isLightened){
        return keyboards.stream()
                .filter(keyboard -> {
                    if(type==null && isLightened==null){
                        return true;
                    }
                    else
                    if (type != null) {
                        if (isLightened != null) {

                            return type.equals(keyboard.getType()) && isLightened.equals(keyboard.getIsLightened());
                        } else {
                            return type.equals(keyboard.getType());
                        }
                    } else {
                        return isLightened.equals(keyboard.getIsLightened());
                    }


                })
                .collect(Collectors.toList());
    }

    public Keyboard addNewKeyboard(Keyboard keyboard){
        keyboard.setId(Math.abs(new Random().nextInt()));
        keyboards.add(keyboard);
        return keyboard;
    }

    public Optional<Keyboard> getKeyboardById(long id){
       return keyboards.stream()
                .filter(keyboard -> keyboard.getId()==id)
                .findFirst();
    }


}
