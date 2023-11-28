package com.yuchi.springbootmall.dao;

import com.yuchi.springbootmall.dto.ProductQueryParams;
import com.yuchi.springbootmall.dto.ProductRequest;
import com.yuchi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
