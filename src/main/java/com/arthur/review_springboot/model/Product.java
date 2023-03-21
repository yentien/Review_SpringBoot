package com.arthur.review_springboot.model;

import com.arthur.review_springboot.constant.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {

    private Integer productId;
    private String productName;
    private ProductCategory category;
    private String imgUrl;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;
}
