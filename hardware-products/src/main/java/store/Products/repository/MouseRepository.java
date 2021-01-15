package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.MouseProduct;
import store.Products.entities.products.Mouse;
import store.Products.querys.MouseQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.MouseQuerys.ADD_MOUSE_SQL;

@Repository
public class MouseRepository {

//    public static List<Mouse> mice=new ArrayList<>();
//    public static List<MouseReview> mouseReviews=new ArrayList<>();
//
//    public MouseRepository(){
//
//
//        Mouse m1=new Mouse(213213121,ProductType.Mouse,"Mouse Gaming Razer Basilisk Ultimate", MouseType.Wireless,"20000 DPI","USB", 539.99,null);
//        Mouse m2=new Mouse(201605175,ProductType.Mouse,"Mouse Gaming Logitech G102 Lightsync",MouseType.Wired,"8000 DPI","USB",124.99,null);
//        Mouse m3=new Mouse(202759652,ProductType.Mouse,"Mouse Microsoft Mobile 1850 for business Black", MouseType.Wireless,"800 DPI","USB", 53.99,null);
//        Mouse m4=new Mouse(201627595,ProductType.Mouse,"Mouse Gaming ASUS TUF Gaming M3 RGB", MouseType.Wired,"8000 DPI","USB", 159.99,null);
//        Mouse m5=new Mouse(201905313,ProductType.Mouse,"Mouse Gaming ASUS ROG Gladius II Origin", MouseType.Wired,"12000 DPI","USB", 269.99,null);
//        Mouse m6=new Mouse(201190545,ProductType.Mouse,"Mouse Gaming Trust GXT 105 Izza", MouseType.Wired,"2400 DPI","USB", 43.99,null);
//        mice.add(m1);
//        mice.add(m2);
//        mice.add(m3);
//        mice.add(m4);
//        mice.add(m5);
//        mice.add(m6);
//    }
//
//    public List<Mouse> getMouse(MouseType type, String maxResolution){
//        return mice.stream()
//                .filter(mouse -> {
//                    if(type==null && maxResolution==null){
//                        return true;
//                    }
//                    else
//                    if (type != null) {
//                        if (maxResolution != null) {
//
//                            return type.equals(mouse.getType()) && maxResolution.equals(mouse.getmaxResolution());
//                        } else {
//                            return type.equals(mouse.getType());
//                        }
//                    } else {
//                        return maxResolution.equals(mouse.getmaxResolution());
//                    }
//
//
//                })
//                .collect(Collectors.toList());
//
//    }
//    public Mouse addNewMouse(Mouse mouse){
//        mouse.setMouseId(Math.abs(new Random().nextInt()));
//        mice.add(mouse);
//        return mouse;
//    }
//
//    public Optional<Mouse> getMouseById(long mouseId){
//     return mice.stream()
//             .filter(mouse -> mouse.getMouseId()==mouseId )
//             .findFirst();
//    }
//
//    public Mouse updateMouse(Mouse mouse, long mouseId){
//        mice.stream()
//                .forEach(upMouse-> {
//                    if(upMouse.getMouseId()==mouseId){
//                        upMouse.setCategory(mouse.getCategory());
//                        upMouse.setModelName(mouse.getModelName());
//                        upMouse.setmaxResolution(mouse.getmaxResolution());
//                        upMouse.setInterfacee(mouse.getInterfacee());
//                        upMouse.setPrice(mouse.getPrice());
//                        upMouse.setMouseReview(mouse.getMouseReview());
//                    }
//                });
//       return mice.stream()
//                .filter(upMouse->upMouse.getMouseId()==mouseId)
//                .findFirst()
//               .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
//    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Mouse> getMouse(){
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE_SQL,new BeanPropertyRowMapper<>(Mouse.class));
    }

    public List<MouseProduct> getMouseProduct(){
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE1_SQL,new BeanPropertyRowMapper<>(MouseProduct.class));
    }

    public List<Mouse> addNewMouse(Mouse mouse){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_MOUSE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mouse.getCategoryName());
            preparedStatement.setString(2, mouse.getMouseType());
            preparedStatement.setString(3, mouse.getMaxResolution());
            preparedStatement.setString(4, mouse.getInterfacee());
           preparedStatement.setInt(5,mouse.getProductId());
            return preparedStatement;
        }, keyHolder);
        mouse.setMouseId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE_SQL,new BeanPropertyRowMapper<>(Mouse.class));

    }
    public List<Mouse> deleteMouse(int id){
        jdbcTemplate.update(MouseQuerys.DELETE_MOUSE_SQL,id);
        return jdbcTemplate.query(MouseQuerys.GET_MOUSE_SQL,new BeanPropertyRowMapper<>(Mouse.class));
    }

    
}
