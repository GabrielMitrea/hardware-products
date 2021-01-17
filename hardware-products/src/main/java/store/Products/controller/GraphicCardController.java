package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.GraphicCardProduct;
import store.Products.entities.products.GraphicCard;
import store.Products.mapper.ProductMapper;
import store.Products.service.GraphicCardService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/graphicCard")
public class GraphicCardController {

    @Autowired
    private GraphicCardService graphicCardService;


    @GetMapping
    public List<GraphicCardProduct> getGraphicCardProduct(){
        return graphicCardService.getGraphicCardProduct();
    }

    @PostMapping("/new")
    public ResponseEntity<List<GraphicCard>> addNewGraphicCard(
            @Valid
            @RequestBody GraphicCard graphicCard){
        graphicCardService.addNewGraphicCard(graphicCard);
        return ResponseEntity.created(null).build();


    }
    @DeleteMapping("/delete")
    public void deleteGraphicCard(@RequestParam int id){
        graphicCardService.deleteGraphicCard(id);
    }

}
