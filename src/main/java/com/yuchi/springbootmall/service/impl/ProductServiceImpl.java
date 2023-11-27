package com.yuchi.springbootmall.service.impl;

import com.yuchi.springbootmall.dao.ProductDao;
import com.yuchi.springbootmall.dao.ProductRequest;
import com.yuchi.springbootmall.model.Product;
import com.yuchi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
