package com.yuchi.springbootmall.service;

import com.yuchi.springbootmall.dao.ProductRequest;
import com.yuchi.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
