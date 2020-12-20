package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.products.GraphicCard;
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
                .created(URI.create("/graphicCard/" + addGraphicCard.getGraphicCardId()))
                .body(addGraphicCard);
    }

    @GetMapping("/{graphicCardId}")
    public GraphicCard getGraphicCardById(@PathVariable long graphicCardId){
        return graphicCardService.getGraphicCardById(graphicCardId);
    }

    @PutMapping("/{graphicCardId}")
    public GraphicCard updateGraphicCard(@RequestBody GraphicCard graphicCard, @PathVariable long graphicCardId){
        return graphicCardService.updateGraphicCard(graphicCard, graphicCardId);
    }
}
