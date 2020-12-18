package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.model.products.Mouse;
import store.Products.model.types.MouseType;
import store.Products.service.MouseService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mouse")
@Validated
public class MouseController {


    @Autowired
    private MouseService mouseService;
    @GetMapping
    public List<Mouse> getMouse(@RequestParam(required = false) MouseType type, @RequestParam(required = false) String maxResolution){
        return mouseService.getMouse(type,maxResolution);
    }

    @GetMapping("/{id}")
    public Mouse getMouseById(@PathVariable long id){
        return mouseService.getMouseById(id);
    }

    @PostMapping
    public ResponseEntity<Mouse> addNewMouse(
            @Valid
            @RequestBody Mouse mouse){
        Mouse addMouse=mouseService.addNewMouse(mouse);
        return ResponseEntity
                .created(URI.create("/mouse/" + addMouse.getId()))
                .body(addMouse);
    }
    @PutMapping("/{id}")
    public Mouse updateMouse(@RequestBody Mouse mouse, @PathVariable long id){
        return mouseService.updateMouse(mouse, id);
    }

}
