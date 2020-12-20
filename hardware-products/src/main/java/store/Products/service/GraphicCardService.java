package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.GraphicCard;
import store.Products.repository.GraphicCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GraphicCardService {

    @Autowired
    private GraphicCardRepository graphicCardRepository;

    public List<GraphicCard> getGraphicCard(String interfacee, String memorySize){
        return graphicCardRepository.getGraphicCard(interfacee,memorySize);
    }

    public GraphicCard addNewGraphicCard(GraphicCard graphicCard) {
        return graphicCardRepository.addNewGraphicCard(graphicCard);
    }
    public GraphicCard getGraphicCardById(long graphicCardId){
        Optional<GraphicCard> graphicCardOptional=graphicCardRepository.getGraphicCardById(graphicCardId);
        if(graphicCardOptional.isPresent()){
            return graphicCardOptional.get();
        }else throw new ProductNotFoundException("Graphic card with Id: " +graphicCardId+ " not found " );
    }
    public GraphicCard updateGraphicCard(GraphicCard graphicCard, long graphicCardId){
        return graphicCardRepository.updateGraphicCard(graphicCard, graphicCardId);
    }

}
