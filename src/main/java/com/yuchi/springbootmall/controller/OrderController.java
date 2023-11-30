package com.yuchi.springbootmall.controller;

import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.model.Order;
import com.yuchi.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService oderService;
    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

       Integer productId = oderService.createOrder(userId, createOrderRequest);
       //Order order = oderService.getOrderById(productId);

       return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}
