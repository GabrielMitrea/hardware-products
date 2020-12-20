package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.entities.products.Headset;
import store.Products.entities.types.HeadsetType;
import store.Products.service.HeadsetService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/headset")
public class HeadsetController {

    @Autowired
    private HeadsetService headsetService;

    @GetMapping
    public List<Headset> getHeadset(@RequestParam(required = false) HeadsetType type, @RequestParam(required = false) String sound){
        return headsetService.getHeadset(type, sound);
    }

    @PostMapping
    public ResponseEntity<Headset> addNewHeadset(
            @Valid
            @RequestBody Headset headset){
        Headset addHeadset=headsetService.addNewHeadset(headset);
        return ResponseEntity
                .created(URI.create("/headset/" + addHeadset.getHeadsetId()))
                .body(addHeadset);
    }

    @GetMapping("/{headsetId}")
    public Headset getHeadsetBygraphicCardId(@PathVariable long headsetId){
        return headsetService.getHeadsetById(headsetId);
    }
    @PutMapping("/{headsetId}")
    public Headset updateHeadset(@RequestBody Headset headset, @PathVariable long headsetId){
        return headsetService.updateHeadset(headset, headsetId);
    }
}
