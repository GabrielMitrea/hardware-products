package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.GraphicCardProduct;
import store.Products.exception.utils.ProductNotFoundException;
import store.Products.entities.products.GraphicCard;
import store.Products.repository.GraphicCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GraphicCardService {

    @Autowired
    private GraphicCardRepository graphicCardRepository;


    public List<GraphicCardProduct> getGraphicCardProduct(){
        return graphicCardRepository.getGraphicCardProduct();

    }

    public List<GraphicCard> addNewGraphicCard(GraphicCard graphicCard) {
        return graphicCardRepository.addNewGraphicCard(graphicCard);
    }

    public void deleteGraphicCard(int id){
        graphicCardRepository.deleteGraphicCard(id);
    }


}
