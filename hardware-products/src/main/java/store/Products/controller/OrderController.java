package store.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.Products.dto.OrderDto;
import store.Products.entities.shoppingCart.Order;
import store.Products.entities.shoppingCart.ShoppingCart;
import store.Products.mapper.ProductMapper;
import store.Products.mapper.ShoppingCartMapper;
import store.Products.service.OrderService;


import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
    
        @Autowired
        private OrderService orderService;

       @Autowired
        private ShoppingCartMapper shoppingCartMapper;
        @GetMapping
        public List<OrderDto> getOrder(){
            return orderService.getOrders();
        }

        @PostMapping("/new")
        public ResponseEntity<Order> addNewOrder(
                @Valid
                @RequestBody Order order){
            orderService.createOrder(order);
            return  ResponseEntity.created(null).build();
        }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam int id){
        orderService.deleteOrder(id);
    }

    
    
}
