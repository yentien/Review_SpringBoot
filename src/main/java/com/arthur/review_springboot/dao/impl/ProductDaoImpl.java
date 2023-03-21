package com.arthur.review_springboot.dao.impl;

import com.arthur.review_springboot.dao.ProductDao;
import com.arthur.review_springboot.dto.ProductRequest;
import com.arthur.review_springboot.model.Product;
import com.arthur.review_springboot.rowmapper.ProductRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
public class ProductDaoImpl implements ProductDao {

    private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 新增商品
    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name, category," +
                " description, img_url, price, stock, created_date," +
                " last_modified_date) values (:productName, :category, :description," +
                " :imgUrl, :price, :stock, :createdDate, :lastModifiedDate)";

        HashMap<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString()); // enum -> String
        map.put("description", productRequest.getDescription());
        map.put("imgUrl", productRequest.getImgUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        Integer productId = Objects.requireNonNull(keyHolder.getKey()).intValue(); // 多加一個不為空判斷
        log.info(String.valueOf(productId));
        return productId;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, description," +
                " img_url, price, stock, created_date, last_modified_date" +
                " FROM product " +
                "WHERE product_id = :productId;";

        HashMap<String, Object> map = new HashMap<>();
        map.put("productId",productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map , new ProductRowMapper());

        if (productList.size() > 0) {
            log.info("{}",productList.get(0));
            return productList.get(0);
        }else {
            log.info("no");
            return null;
        }
    }
}
