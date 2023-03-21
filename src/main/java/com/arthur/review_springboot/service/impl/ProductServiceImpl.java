package com.arthur.review_springboot.service.impl;

import com.arthur.review_springboot.dao.ProductDao;
import com.arthur.review_springboot.dto.ProductRequest;
import com.arthur.review_springboot.model.Product;
import com.arthur.review_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
