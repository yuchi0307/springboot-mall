package com.yuchi.springbootmall.service;

import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.dto.OrderQueryParams;
import com.yuchi.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
