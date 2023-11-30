package com.yuchi.springbootmall.rowmapper;

import com.yuchi.springbootmall.model.Order;
import com.yuchi.springbootmall.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//        Order order = new Order();
//        order.setOrderId(resultSet.getInt("order_id"));
//        order.setUserId(resultSet.getInt("user_id"));
//        order.setTotalAmount(resultSet.getInt("total_amount"));
//        order.setCreatedDate(resultSet.getTimestamp("created_date"));
//        order.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
//
//        return order;
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(resultSet.getInt("order_item_id"));
        orderItem.setOrderId(resultSet.getInt("order_id"));
        orderItem.setProductId(resultSet.getInt("product_id"));
        orderItem.setQuantity(resultSet.getInt("quantity"));
        orderItem.setAmount(resultSet.getInt("amount"));

        orderItem.setProductName(resultSet.getString("product_name"));
        orderItem.setImageUrl(resultSet.getString("image_url"));

        return orderItem;
    }
}
