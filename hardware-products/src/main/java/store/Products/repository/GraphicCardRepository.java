package store.Products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import store.Products.dto.GraphicCardProduct;
import store.Products.entities.products.GraphicCard;
import store.Products.querys.GraphicQuerys;



import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static store.Products.querys.GraphicQuerys.ADD_GRAPHICCARD_SQL;


@Repository
public class GraphicCardRepository {

//    public static List<GraphicCard> graphicCards=new ArrayList<>();
//
//    public GraphicCardRepository(){
//
//
//        graphicCards.add(new GraphicCard(123456789,ProductType.GraphicCard,"Placa video XFX Radeon RX 580 GTS XXX Edition","8 GB","GDDR5","PCI Express x16 3.0",1064.99,null));
//        graphicCards.add(new GraphicCard(214142516, ProductType.GraphicCard,"Placa video Sapphire Radeon RX 550 PULSE","4 GB","GDDR5","PCI Express x16 3.0",439.99,null));
//        graphicCards.add(new GraphicCard(863725451, ProductType.GraphicCard,"Placa video ASRock Radeon RX 5600 XT Challenger D OC","6 GB","GDDR6","PCI Express x16 4.0",1549.99,null));
//        graphicCards.add(new GraphicCard(941536131, ProductType.GraphicCard,"Placa video PowerColor Radeon RX 5500 XT","8 GB","GDDR6","PCI Express x16 4.0",1029.99,null));
//        graphicCards.add(new GraphicCard(214124125, ProductType.GraphicCard,"Placa video MSI GeForce GT 730 ","4 GB","DDR3","PCI express x16 2.0",344.99,null));
//
//    }
//
//    public List<GraphicCard> getGraphicCard(String interfacee, String memorySize){
//        return graphicCards.stream()
//                .filter(graphicCard -> {
//                    if(interfacee==null && memorySize==null){
//                        return true;
//                    }
//                    else
//                    if (interfacee != null) {
//                        if (memorySize != null) {
//
//                            return interfacee.equals(graphicCard.getInterfacee()) && memorySize.equals(graphicCard.getMemorySize());
//                        } else {
//                            return interfacee.equals(graphicCard.getInterfacee());
//                        }
//                    } else {
//                        return memorySize.equals(graphicCard.getMemorySize());
//                    }
//
//
//                })
//                .collect(Collectors.toList());
//    }
//    public GraphicCard addNewGraphicCard(GraphicCard graphicCard){
//        graphicCard.setGraphicCardId(Math.abs(new Random().nextInt()));
//        graphicCards.add(graphicCard);
//        return graphicCard;
//    }
//
//    public Optional<GraphicCard> getGraphicCardById(long graphicCardId){
//        return graphicCards.stream()
//                .filter(graphicCard -> graphicCard.getGraphicCardId()==graphicCardId)
//                .findFirst();
//    }
//
//    public GraphicCard updateGraphicCard(GraphicCard graphicCard, long graphicCardId){
//        graphicCards.stream()
//                .forEach(upGraphicCard-> {
//                    if(upGraphicCard.getGraphicCardId()==graphicCardId){
//                        upGraphicCard.setCategory(graphicCard.getCategory());
//                        upGraphicCard.setModelName(graphicCard.getModelName());
//                        upGraphicCard.setMemorySize(graphicCard.getMemorySize());
//                        upGraphicCard.setMemoryType(graphicCard.getMemoryType());
//                        upGraphicCard.setInterfacee(graphicCard.getInterfacee());
//                        upGraphicCard.setPrice(graphicCard.getPrice());
//                        upGraphicCard.setGraphicCardReview(graphicCard.getGraphicCardReview());
//                    }
//                });
//        return graphicCards.stream()
//                .filter(upGraphicCard->upGraphicCard.getGraphicCardId()==graphicCardId)
//                .findFirst()
//                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<GraphicCard> getGraphicCard(){
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD_SQL,new BeanPropertyRowMapper<>(GraphicCard.class));
    }

    public List<GraphicCardProduct> getGraphicCardProduct(){
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD1_SQL,new BeanPropertyRowMapper<>(GraphicCardProduct.class));
    }
    public List<GraphicCard> addNewGraphicCard(GraphicCard graphicCard){
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_GRAPHICCARD_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, graphicCard.getCategoryName());
            preparedStatement.setString(2, graphicCard.getMemorySize());
            preparedStatement.setString(3, graphicCard.getMemoryType());
            preparedStatement.setString(4, graphicCard.getInterfacee());
            preparedStatement.setInt(5, graphicCard.getProductId());
            return preparedStatement;
        }, keyHolder);
        graphicCard.setGraphicCardId(keyHolder.getKey().intValue());
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD_SQL,new BeanPropertyRowMapper<>(GraphicCard.class));

    }

    public List<GraphicCard> deleteGraphicCard(int id){
        jdbcTemplate.update(GraphicQuerys.DELETE_GRAPHICCARD_SQL,id);
        return jdbcTemplate.query(GraphicQuerys.GET_GRAPHICCARD_SQL,new BeanPropertyRowMapper<>(GraphicCard.class));
    }
}
