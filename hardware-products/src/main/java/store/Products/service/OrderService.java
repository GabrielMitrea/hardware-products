package store.Products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.Products.dto.OrderDto;
import store.Products.entities.shoppingCart.Order;
import store.Products.repository.OrderRepository;


import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> getOrders(){
        return orderRepository.getOrders();
    }

    public Order createOrder(Order order){
        return orderRepository.createOrder(order);
    }

   public void deleteOrder(int id){
         orderRepository.deleteOrder(id);
    }

}
