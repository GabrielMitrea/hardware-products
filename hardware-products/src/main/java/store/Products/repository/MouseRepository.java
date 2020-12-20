package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.types.ProductType;
import store.Products.entities.products.Mouse;
import store.Products.entities.types.MouseType;
import store.Products.entities.reviews.MouseReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class MouseRepository {

    public static List<Mouse> mice=new ArrayList<>();
    public static List<MouseReview> mouseReviews=new ArrayList<>();

    public MouseRepository(){


        Mouse m1=new Mouse(213213121,ProductType.Mouse,"Mouse Gaming Razer Basilisk Ultimate", MouseType.Wireless,"20000 DPI","USB", 539.99,null);
        Mouse m2=new Mouse(201605175,ProductType.Mouse,"Mouse Gaming Logitech G102 Lightsync",MouseType.Wired,"8000 DPI","USB",124.99,null);
        Mouse m3=new Mouse(202759652,ProductType.Mouse,"bbbbbb", MouseType.Wireless,"15000 DPI","USB", 539.99,null);
        Mouse m4=new Mouse(201627595,ProductType.Mouse,"safasfa", MouseType.Wired,"2000 DPI","USB", 539.99,null);
        Mouse m5=new Mouse(201905313,ProductType.Mouse,"gege", MouseType.Wired,"20000 DPI","USB", 539.99,null);
        Mouse m6=new Mouse(201190545,ProductType.Mouse,"baba", MouseType.Wired,"20000 DPI","USB", 539.99,null);
        mice.add(m1);
        mice.add(m2);
        mice.add(m3);
        mice.add(m4);
        mice.add(m5);
        mice.add(m6);
    }

    public List<Mouse> getMouse(MouseType type, String maxResolution){
        return mice.stream()
                .filter(mouse -> {
                    if(type==null && maxResolution==null){
                        return true;
                    }
                    else
                    if (type != null) {
                        if (maxResolution != null) {

                            return type.equals(mouse.getType()) && maxResolution.equals(mouse.getmaxResolution());
                        } else {
                            return type.equals(mouse.getType());
                        }
                    } else {
                        return maxResolution.equals(mouse.getmaxResolution());
                    }


                })
                .collect(Collectors.toList());

    }
    public Mouse addNewMouse(Mouse mouse){
        mouse.setMouseId(Math.abs(new Random().nextInt()));
        mice.add(mouse);
        return mouse;
    }

    public Optional<Mouse> getMouseById(long mouseId){
     return mice.stream()
             .filter(mouse -> mouse.getMouseId()==mouseId )
             .findFirst();
    }

    public Mouse updateMouse(Mouse mouse, long mouseId){
        mice.stream()
                .forEach(upMouse-> {
                    if(upMouse.getMouseId()==mouseId){
                        upMouse.setCategory(mouse.getCategory());
                        upMouse.setModelName(mouse.getModelName());
                        upMouse.setmaxResolution(mouse.getmaxResolution());
                        upMouse.setInterfacee(mouse.getInterfacee());
                        upMouse.setPrice(mouse.getPrice());
                        upMouse.setMouseReview(mouse.getMouseReview());
                    }
                });
       return mice.stream()
                .filter(upMouse->upMouse.getMouseId()==mouseId)
                .findFirst()
               .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
    }
}
