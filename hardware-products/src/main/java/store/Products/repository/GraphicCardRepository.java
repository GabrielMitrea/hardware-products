package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.types.ProductType;
import store.Products.entities.products.GraphicCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class GraphicCardRepository {

    public static List<GraphicCard> graphicCards=new ArrayList<>();

    public GraphicCardRepository(){


        graphicCards.add(new GraphicCard(123456789,ProductType.GraphicCard,"m1","s1","t1","i1",24.99,null));
        graphicCards.add(new GraphicCard(214142516, ProductType.GraphicCard,"m2","s2","t2","i2",20.00,null));
        graphicCards.add(new GraphicCard(863725451, ProductType.GraphicCard,"m3","s3","t3","i3",21.31,null));
        graphicCards.add(new GraphicCard(941536131, ProductType.GraphicCard,"m4","s4","t4","i4",500.21,null));
        graphicCards.add(new GraphicCard(214124125, ProductType.GraphicCard,"m5","s5","t5","i5",320.99,null));

    }

    public List<GraphicCard> getGraphicCard(String interfacee, String memorySize){
        return graphicCards.stream()
                .filter(graphicCard -> {
                    if(interfacee==null && memorySize==null){
                        return true;
                    }
                    else
                    if (interfacee != null) {
                        if (memorySize != null) {

                            return interfacee.equals(graphicCard.getInterfacee()) && memorySize.equals(graphicCard.getMemorySize());
                        } else {
                            return interfacee.equals(graphicCard.getInterfacee());
                        }
                    } else {
                        return memorySize.equals(graphicCard.getMemorySize());
                    }


                })
                .collect(Collectors.toList());
    }
    public GraphicCard addNewGraphicCard(GraphicCard graphicCard){
        graphicCard.setGraphicCardId(Math.abs(new Random().nextInt()));
        graphicCards.add(graphicCard);
        return graphicCard;
    }

    public Optional<GraphicCard> getGraphicCardById(long graphicCardId){
        return graphicCards.stream()
                .filter(graphicCard -> graphicCard.getGraphicCardId()==graphicCardId)
                .findFirst();
    }

    public GraphicCard updateGraphicCard(GraphicCard graphicCard, long graphicCardId){
        graphicCards.stream()
                .forEach(upGraphicCard-> {
                    if(upGraphicCard.getGraphicCardId()==graphicCardId){
                        upGraphicCard.setCategory(graphicCard.getCategory());
                        upGraphicCard.setModelName(graphicCard.getModelName());
                        upGraphicCard.setMemorySize(graphicCard.getMemorySize());
                        upGraphicCard.setMemoryType(graphicCard.getMemoryType());
                        upGraphicCard.setInterfacee(graphicCard.getInterfacee());
                        upGraphicCard.setPrice(graphicCard.getPrice());
                        upGraphicCard.setGraphicCardReview(graphicCard.getGraphicCardReview());
                    }
                });
        return graphicCards.stream()
                .filter(upGraphicCard->upGraphicCard.getGraphicCardId()==graphicCardId)
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException("Wrong or not found id for this request"));
    }
}
