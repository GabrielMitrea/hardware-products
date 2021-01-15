package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.ShoppingCartRequest;
import store.Products.entities.shoppingCart.ShoppingCart;
import store.Products.repository.ShoppingCartRepository;

import java.util.List;

@Service
public class ShoppingCartService {


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> getCart(){
        return shoppingCartRepository.getCart();
    }

    public List<ShoppingCartRequest> getCartItem(){
        return shoppingCartRepository.getCartItem();
    }

    public List<ShoppingCart> addItemInCart(ShoppingCart shoppingCart){
         return shoppingCartRepository.addItemInCart(shoppingCart);
    }
}
