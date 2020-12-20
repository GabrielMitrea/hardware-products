package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.types.ProductType;
import store.Products.entities.products.Keyboard;
import store.Products.entities.reviews.KeyboardReview;
import store.Products.entities.types.KeyboardType;

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

        Keyboard k1=new Keyboard(214124214, ProductType.Keyboard,"Tastatura Gaming Razer Ornata V2",KeyboardType.Wired,"Da","Da", 294.99,null);
        Keyboard k2=new Keyboard(525762431, ProductType.Keyboard,"astatura Gaming T-Dagger Bermuda TGK312 ",KeyboardType.Wired,"Da","Da", 239.99,keyboardReview);
        Keyboard k3=new Keyboard(352352157, ProductType.Keyboard,"Tastatura cu fir MYRIA MY8518",KeyboardType.Wired,"Nu","Nu", 39.90,null);
        Keyboard k4=new Keyboard(532523523, ProductType.Keyboard,"Tastatura Gaming MARVO K629G",KeyboardType.Wired,"Nu","Nu", 99.00,null);
        Keyboard k5=new Keyboard(743571123, ProductType.Keyboard,"Tastatura Gaming Logitech G915 LIGHTSPEED ",KeyboardType.Wireless,"Da","Da", 1130.00,null);
        Keyboard k6=new Keyboard(235412541, ProductType.Keyboard,"Tastatura Gaming Logitech G613 ",KeyboardType.Wireless,"Nu","Da", 649.99,null);
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
        keyboard.setKeyboardId(Math.abs(new Random().nextInt()));
        keyboards.add(keyboard);
        return keyboard;
    }

    public Optional<Keyboard> getKeyboardById(long keyboardId){
       return keyboards.stream()
                .filter(keyboard -> keyboard.getKeyboardId()==keyboardId)
                .findFirst();
    }

    public Keyboard updateKeyboard(Keyboard keyboard, long keyboardId){
        keyboards.stream()
                .forEach(upKeyboard-> {
                    if(upKeyboard.getKeyboardId()==keyboardId){
                        upKeyboard.setCategory(keyboard.getCategory());
                        upKeyboard.setModelName(keyboard.getModelName());
                        upKeyboard.setType(keyboard.getType());
                        upKeyboard.setIsLightened(keyboard.getIsLightened());
                        upKeyboard.setIsMechanic(keyboard.getIsMechanic());
                        upKeyboard.setPrice(keyboard.getPrice());
                        upKeyboard.setKeyboardReview(keyboard.getKeyboardReview());
                    }
                });
        return keyboards.stream()
                .filter(upKeyboard->upKeyboard.getKeyboardId()==keyboardId)
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
    }

}
