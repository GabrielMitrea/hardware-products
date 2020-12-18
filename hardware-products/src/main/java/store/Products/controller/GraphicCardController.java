package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.model.products.GraphicCard;
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
    public List<GraphicCard> getGraphicCard(@RequestParam(required = false) String interfacee, @RequestParam(required = false) String memorySize){
        return graphicCardService.getGraphicCard(interfacee,memorySize);
    }

    @PostMapping
    public ResponseEntity<GraphicCard> addNewGraphicCard(
            @Valid
            @RequestBody GraphicCard graphicCard){
        GraphicCard addGraphicCard=graphicCardService.addNewGraphicCard(graphicCard);
        return ResponseEntity
                .created(URI.create("/graphicCard/" + addGraphicCard.getId()))
                .body(addGraphicCard);
    }

    @GetMapping("/{id}")
    public GraphicCard getGraphicCardById(@PathVariable long id){
        return graphicCardService.getGraphicCardById(id);
    }

}
