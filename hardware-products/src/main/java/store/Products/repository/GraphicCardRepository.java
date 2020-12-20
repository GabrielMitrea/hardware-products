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


        graphicCards.add(new GraphicCard(123456789,ProductType.GraphicCard,"Placa video XFX Radeon RX 580 GTS XXX Edition","8 GB","GDDR5","PCI Express x16 3.0",1064.99,null));
        graphicCards.add(new GraphicCard(214142516, ProductType.GraphicCard,"Placa video Sapphire Radeon RX 550 PULSE","4 GB","GDDR5","PCI Express x16 3.0",439.99,null));
        graphicCards.add(new GraphicCard(863725451, ProductType.GraphicCard,"Placa video ASRock Radeon RX 5600 XT Challenger D OC","6 GB","GDDR6","PCI Express x16 4.0",1549.99,null));
        graphicCards.add(new GraphicCard(941536131, ProductType.GraphicCard,"Placa video PowerColor Radeon RX 5500 XT","8 GB","GDDR6","PCI Express x16 4.0",1029.99,null));
        graphicCards.add(new GraphicCard(214124125, ProductType.GraphicCard,"Placa video MSI GeForce GT 730 ","4 GB","DDR3","PCI express x16 2.0",344.99,null));

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
