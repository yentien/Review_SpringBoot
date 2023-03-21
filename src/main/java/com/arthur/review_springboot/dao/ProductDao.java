package com.arthur.review_springboot.dao;

import com.arthur.review_springboot.dto.ProductRequest;
import com.arthur.review_springboot.model.Product;

public interface ProductDao {

    // 新增商品
    Integer createProduct(ProductRequest productRequest);

    // 查詢單一商品
    Product getProductById(Integer productId);
}
