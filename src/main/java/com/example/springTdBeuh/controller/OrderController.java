package com.example.springTdBeuh.controller;

import com.example.springTdBeuh.model.OrderUser;
import com.example.springTdBeuh.repo.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private final OrderRepository repositoryOrder;


    OrderController(OrderRepository repositoryOrder) {
         this.repositoryOrder = repositoryOrder;
     }

    @GetMapping("/order")
    List<OrderUser> all() {
        return repositoryOrder.findAll();
    }

    // end::get-aggregate-root[]
    @PostMapping("/order")
    OrderUser newOrder(@RequestBody OrderUser newOrderUser) {

        return repositoryOrder.save(newOrderUser);
    }

    // Single item
    @GetMapping("/order/{id}")
    Optional<OrderUser> one(@PathVariable Long id) {
        return repositoryOrder.findById(id);
    }

//    @PutMapping("/order/{id}")
//    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
//
//        return repositoryOrder.findById(id)
//                .map(order -> {
//                    order.setSerialNumber(newOrder.getSerialNumber());
//                    order.setPrice(newOrder.getPrice());
//                    order.setUnit(newOrder.getUnit());
//                    order.setQuantityInStock(newOrder.getQuantityInStock());
//                    return repositoryOrder.save(order);
//                })
//                .orElseGet(() -> {
//                    newOrder.setId(id);
//                    return repositoryOrder.save(newOrder);
//                });
//    }

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable Long id) {
        repositoryOrder.deleteById(id);
    }
}
