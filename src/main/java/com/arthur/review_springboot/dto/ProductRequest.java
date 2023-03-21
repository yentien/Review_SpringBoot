package com.arthur.review_springboot.dto;

import com.arthur.review_springboot.constant.ProductCategory;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull
    private String productName;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String imgUrl;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer stock;

    private String description;
}
