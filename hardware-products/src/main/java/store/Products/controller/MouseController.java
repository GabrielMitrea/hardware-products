package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.products.Mouse;
import store.Products.entities.types.MouseType;
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

    @GetMapping("/{mouseId}")
    public Mouse getMouseById(@PathVariable long mouseId){
        return mouseService.getMouseById(mouseId);
    }

    @PostMapping
    public ResponseEntity<Mouse> addNewMouse(
            @Valid
            @RequestBody Mouse mouse){
        Mouse addMouse=mouseService.addNewMouse(mouse);
        return ResponseEntity
                .created(URI.create("/mouse/" + addMouse.getMouseId()))
                .body(addMouse);
    }
    @PutMapping("/{mouseId}")
    public Mouse updateMouse(@RequestBody Mouse mouse, @PathVariable long mouseId){
        return mouseService.updateMouse(mouse, mouseId);
    }

}
