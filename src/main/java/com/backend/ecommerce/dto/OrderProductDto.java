package com.backend.ecommerce.dto;

import com.backend.ecommerce.entity.Product;
import lombok.Data;

@Data
public class OrderProductDto {
    private Product product;
    private Integer quantity;
}
