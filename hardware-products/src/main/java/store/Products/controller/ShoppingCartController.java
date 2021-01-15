package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.ShoppingCartRequest;
import store.Products.entities.products.Mouse;
import store.Products.entities.shoppingCart.ShoppingCart;
import store.Products.mapper.ShoppingCartMapper;
import store.Products.service.ShoppingCartService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class ShoppingCartController {


    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService=shoppingCartService;

    }

    @GetMapping
    public List<ShoppingCartRequest> getCartItem(){
        return shoppingCartService.getCartItem();
    }


    @PostMapping("/new")
    public ResponseEntity<List<ShoppingCart>> addItemInCart(@RequestBody ShoppingCart shoppingCart) {
    shoppingCartService.addItemInCart(shoppingCart);
    return ResponseEntity
            .created(null).build();

}
}