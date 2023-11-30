package com.yuchi.springbootmall.service;

import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
