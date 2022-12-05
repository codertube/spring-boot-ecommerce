package com.backend.ecommerce.dto;

import com.backend.ecommerce.entity.Category;
import lombok.Data;

@Data
public class ProductDto {
    private Category category;
    private String name;
    private Double price;
    private Integer quantity;
    private String imageUrl;
}
