package com.yuchi.springbootmall.service;

import com.yuchi.springbootmall.dao.ProductRequest;
import com.yuchi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
