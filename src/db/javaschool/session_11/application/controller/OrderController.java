package db.javaschool.session_11.application.controller;

import db.javaschool.session_11.application.entities.Order;
import db.javaschool.session_11.application.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order getOrderByID(@PathVariable(value = "id") long id){ return orderRepository.getOrderByID(id); }

    @PutMapping("/")
    public void insertOrder(@RequestBody Order order){
        orderRepository.insertOrder(order);
    }

}
