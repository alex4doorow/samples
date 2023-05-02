package com.sir.richard.boss.rest;

import com.sir.richard.boss.bl.core.CoreException;
import com.sir.richard.boss.model.data.Order;
import com.sir.richard.boss.rest.dto.DtoOrder;
import com.sir.richard.boss.services.OrderService;
import com.sir.richard.boss.services.converters.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

//        HTTP GET http://www.javadevjournal.com/orders  //Get all orders
//        HTTP GET http://www.javadevjournal.com/orders/{order-id}  //Get order based on order code
//        HTTP POST http://www.javadevjournal.com/users  //Registers a customer.
//
//        HTTP PUT http://www.javadevjournal.com/users/{userId}  //Updates customer profile.
//        HTTP DELETE http://www.javadevjournal.com/users/{userId}  //Removes customer profile

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderRestController {

    @Autowired
    private OrderService orderService;
    @Autowired
    JsonMapper jsonMapper;

    @GetMapping
    Iterable<Order> getList() {
        return null;
    }

    @GetMapping("/{id}")
    Optional<DtoOrder> findDataById(@PathVariable Long id) {
        log.info("[START] {} request: {}", "FIND", id);
        return orderService.findById(id);
    }

    @PostMapping()
    Optional<DtoOrder> addData(@RequestBody String body) throws CoreException {
        log.info("[START] {} request:\n{}", "ADD", body);
        DtoOrder dtoOrder = jsonMapper.fromJSON(body, DtoOrder.class);
        orderService.add(dtoOrder);
        return orderService.findById(dtoOrder.getId());
    }

    @PutMapping("/{id}")
    ResponseEntity<DtoOrder> updateData(@PathVariable Long id,
                                     @RequestBody String body) throws CoreException {
        log.info("[START] {} request:\n{}", "UPDATE", body);
        DtoOrder dtoOrder = jsonMapper.fromJSON(body, DtoOrder.class);
        orderService.update(dtoOrder);

        /*
        int coffeeIndex = -1;
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);

         */

        return new ResponseEntity<>(dtoOrder, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    void deleteData(@PathVariable Long id) {
        log.info("[START] {} request: {}", "DELETE", id);

        //coffees.removeIf(c -> c.getId().equals(id));
    }
}
