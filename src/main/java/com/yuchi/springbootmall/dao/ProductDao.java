package com.yuchi.springbootmall.dao;

import com.yuchi.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
