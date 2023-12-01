package com.yuchi.springbootmall.controller;

import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.dto.OrderQueryParams;
import com.yuchi.springbootmall.model.Order;
import com.yuchi.springbootmall.service.OrderService;
import com.yuchi.springbootmall.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class OrderController {
    private final static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService oderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
            @PathVariable Integer userId,
            @RequestParam (defaultValue = "10") @Max(1000) @Min(0) Integer limit,
            @RequestParam (defaultValue = "0") @Min(0) Integer offset
    ){
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);
        //取得 order list
        List<Order> orderList = oderService.getOrders(orderQueryParams);

        //取得 order 總數
        Integer count = oderService.countOrder(orderQueryParams);

        //分頁
        Page<Order> page = new Page();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

       Integer orderId = oderService.createOrder(userId, createOrderRequest);
       Order order = oderService.getOrderById(orderId);
        log.warn("userID的值: {} ", userId);
       return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
