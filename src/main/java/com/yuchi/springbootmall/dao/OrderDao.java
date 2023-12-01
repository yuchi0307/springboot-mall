package com.yuchi.springbootmall.dao;

import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.dto.OrderQueryParams;
import com.yuchi.springbootmall.model.Order;
import com.yuchi.springbootmall.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;


public interface OrderDao {
   Integer createOrder(Integer userId, Integer totalAmount);

   void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

   Order getOrderById(Integer orderId);

   List<OrderItem> getOrderItemsByOrderId(Integer orderId);

   List<Order>getOrders(OrderQueryParams orderQueryParams);

   Integer countOrder(OrderQueryParams orderQueryParams);
}
