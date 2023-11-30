package com.yuchi.springbootmall.service.impl;

import com.yuchi.springbootmall.dao.OrderDao;
import com.yuchi.springbootmall.dao.ProductDao;
import com.yuchi.springbootmall.dto.BuyItem;
import com.yuchi.springbootmall.dto.CreateOrderRequest;
import com.yuchi.springbootmall.model.Order;
import com.yuchi.springbootmall.model.OrderItem;
import com.yuchi.springbootmall.model.Product;
import com.yuchi.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem:createOrderRequest.getBuyItemList()){

            //用前端傳進來的參數 buyItem.getProductId 查詢資料庫 product的資料
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    //@Override
//    public Order getOrderById(Integer useId) {
//
//        return orderDao.getOrderById(useId);
//    }
}
