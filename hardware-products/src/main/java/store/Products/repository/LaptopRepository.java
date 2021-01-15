package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.LaptopProduct;
import store.Products.entities.products.Laptop;
import store.Products.querys.LaptopQuerys;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.LaptopQuerys.ADD_LAPTOP_SQL;


@Repository
public class LaptopRepository {

//    public static List<Laptop> laptops=new ArrayList<>();
//
//    public LaptopRepository(){
//
//
//        laptops.add(new Laptop(1609229152, ProductType.Laptop,"Laptop ASUS Gaming 15.6'' ROG Strix G G531GT", LaptopType.Gaming,"Intel® Core™ i7-9750H","NVIDIA GeForce GTX 1650","8GB RAM","512GB SSD",4999.99, null));
//        laptops.add(new Laptop(1491888111,  ProductType.Laptop,"Laptop Lenovo Gaming 15.6'' IdeaPad 3 15IMH05, FHD IPS", LaptopType.Gaming,"Intel® Core™ i7-10750H","NVIDIA GeForce GTX 1650","8GB RAM","512GB SSD",4189.99, null));
//        laptops.add(new Laptop(1608595386,  ProductType.Laptop,"Laptop ASUS Gaming 15.6'' ROG Strix G15 G512LV, FHD 240Hz", LaptopType.Gaming,"Intel® Core™ i5-10300H","NVIDIA GeForce RTX 2060 6GB","16GB RAM","1TB SSD",6198.99, null));
//        laptops.add(new Laptop(559695151,  ProductType.Laptop,"Laptop Lenovo 15.6'' V15 IIL, FHD", LaptopType.Business,"Intel® Core™ i7-1065G7 ","Intel Iris Plus","12 GB RAM","512GB SSD",3998.99, null));
//        laptops.add(new Laptop(1646484793,  ProductType.Laptop,"Laptop Lenovo 15.6'' ThinkBook 15 G2 ARE, FHD", LaptopType.Business,"AMD Ryzen™ 3 4300U","AMD Radeon","8GB RAM","256GB SSD",3000.99, null));
//
//    }
//
//    public List<Laptop> getLaptop(LaptopType type, String gpuModel){
//        return laptops.stream()
//                .filter(laptop -> {
//                    if(type==null && gpuModel==null){
//                        return true;
//                    }
//                    else
//                    if (type != null) {
//                        if (gpuModel!= null) {
//
//                            return type.equals(laptop.getType()) && gpuModel.equals(laptop.getgpuModel());
//                        } else {
//                            return type.equals(laptop.getType());
//                        }
//                    } else {
//                        return gpuModel.equals(laptop.getgpuModel());
//                    }
//
//
//                })
//                .collect(Collectors.toList());
//    }
//    public Laptop addNewLaptop(Laptop laptop){
//        laptop.setLaptopId(Math.abs(new Random().nextInt()));
//        laptops.add(laptop);
//        return laptop;
//    }
//
//    public Optional<Laptop> getLaptopById(long laptopId){
//        return laptops.stream()
//                .filter(laptop -> laptop.getLaptopId()==laptopId)
//                .findFirst();
//    }
//
//    public Laptop updateLaptop(Laptop laptop, long laptopId){
//        laptops.stream()
//                .forEach(upLaptop-> {
//                    if(upLaptop.getLaptopId()==laptopId){
//                        upLaptop.setCategory(laptop.getCategory());
//                        upLaptop.setModel(laptop.getModel());
//                        upLaptop.setType(laptop.getType());
//                        upLaptop.setcpuModel(laptop.getcpuModel());
//                        upLaptop.setgpuModel(laptop.getgpuModel());
//                        upLaptop.setMemoryRamSize(laptop.getMemoryRamSize());
//                        upLaptop.setStorageCapacity(laptop.getStorageCapacity());
//                        upLaptop.setPrice(laptop.getPrice());
//                        upLaptop.setlaptopReviews(laptop.getlaptopReviews());
//                    }
//                });
//        return laptops.stream()
//                .filter(upLaptop->upLaptop.getLaptopId()==laptopId)
//                .findFirst()
//                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Laptop> getLaptop(){
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP_SQL,new BeanPropertyRowMapper<>(Laptop.class));
    }

    public List<LaptopProduct> getLaptopProduct(){
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP1_SQL,new BeanPropertyRowMapper<>(LaptopProduct.class));
    }
    public List<Laptop> addNewLaptop(Laptop laptop){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_LAPTOP_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, laptop.getCategoryName());
            preparedStatement.setString(2, laptop.getLaptopType());
            preparedStatement.setString(3, laptop.getCpuModel());
            preparedStatement.setString(4, laptop.getGpuModel());
            preparedStatement.setString(5, laptop.getMemoryRamSize());
            preparedStatement.setString(6, laptop.getStorageCapacity());
            preparedStatement.setInt(7,laptop.getProductId());
            return preparedStatement;
        }, keyHolder);
        laptop.setProductId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP_SQL,new BeanPropertyRowMapper<>(Laptop.class));

    }
    public List<Laptop> deleteLaptop(int id){
        jdbcTemplate.update(LaptopQuerys.DELETE_LAPTOP_SQL,id);
        return jdbcTemplate.query(LaptopQuerys.GET_LAPTOP_SQL,new BeanPropertyRowMapper<>(Laptop.class));
    }
}
